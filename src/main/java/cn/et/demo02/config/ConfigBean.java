package cn.et.demo02.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
public class ConfigBean {
    /**
     * 该方法等价于：
     * <bean id ="druidStaView" class="ServletRegistrationBean"/>
     */
    @Bean
    public ServletRegistrationBean druidStaView(){
        ServletRegistrationBean srb =new ServletRegistrationBean();
        srb.setName("DruidStaView");
        StatViewServlet svs =new StatViewServlet();
        srb.setServlet(svs);
        String url ="/druid/*";
        List<String> urls =new ArrayList<String>();
        urls.add(url);
        srb.setUrlMappings(urls);
        LinkedHashMap<String, String> linkedHashMap =new LinkedHashMap<String, String>();
        linkedHashMap.put("loginUsername", "admin");
        linkedHashMap.put("loginPassword", "123456");
        srb.setInitParameters(linkedHashMap);
        return srb;
    }
}
