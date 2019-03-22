package cn.et.helloTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * RestController 这个注解是Controller的子类里面还包含了ResponseBody 所以返回的时候就不需要在方法上写ResponseBody了
 */
@RestController
@RequestMapping("hello")
public class HelloWorldTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("test1")
    public List test1(){
        List list =new ArrayList();
        list.add("张三");
        list.add("李四");
        return list;
    }

    /**
     * 一个简单的查询
     * @return
     */
    @RequestMapping("test2")
    public List test2(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from student");
        return maps;
    }
}
