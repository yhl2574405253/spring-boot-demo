
package cn.et.demo03.config;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;


@Configuration
public class ShiRoConfig {
    /**
     等价于 web.xml配置
     <filter>
     <filter-name>shiRoFilter</filter-name>
     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
     <init-param>
     <param-name>targetFilterLifecycle</param-name>
     <param-value>true</param-value>
     </init-param>
     </filter>
     <filter-mapping>
     <filter-name>shiRoFilter</filter-name>
     <url-pattern>/*</url-pattern>
     </filter-mapping>
     * @return
     */
    @Bean
    public FilterRegistrationBean webShiRoFilter(){
        FilterRegistrationBean frb=new FilterRegistrationBean();
        DelegatingFilterProxy dfp=new DelegatingFilterProxy();
        frb.setFilter(dfp);
        frb.setName("shiRoFilter");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("/*");
        frb.setUrlPatterns(linkedHashSet);


        Map<String, String> initParameters=new HashMap<String, String>();
        initParameters.put("targetFilterLifecycle", "true");
        frb.setInitParameters(initParameters);
        return frb;
    }
    /**
     * 配置我的realm
     * @return
     */
    @Bean
    public Realm myRealm(){
        return new MyRealm();
    }

    /**
     * 定义默认的securityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Autowired Realm myRealm){
        DefaultWebSecurityManager dwm=new DefaultWebSecurityManager();
        dwm.setRealm(myRealm);
        return dwm;
    }

    /**
     * 定义和过滤器一致名字的shiRoFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiRoFilter(@Autowired SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean=new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
//      如果需要授权就跳转到这个路径
        filterFactoryBean.setLoginUrl("/Login.jsp");
//      如果没有权限就跳转到这个路径
        filterFactoryBean.setUnauthorizedUrl("/RoleError.jsp");

//      自定义一个过滤器
        Map<String, String> urls=new HashMap<String, String>();
        urls.put("/**", "myFilter");
//        urls.put("/Login.jsp", "anon");
//        urls.put("/LoginSuccess.jsp", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(urls);
        return filterFactoryBean;
    }
    /**
     * 定义ShiRo的生命周期
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
}