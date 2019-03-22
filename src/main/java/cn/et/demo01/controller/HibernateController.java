package cn.et.demo01.controller;

import cn.et.demo01.model.Student;
import cn.et.demo01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController 这个注解是Controller的子类里面还包含了ResponseBody 所以返回的时候就不需要在方法上写ResponseBody了
 */
@RestController
@RequestMapping("demo01")
public class HibernateController {
    @Autowired
    StudentService studentService;

    /**
     * 添加
     * @return
     */
    @RequestMapping("insert")
    public String insert(){
        Student student = new Student();
        student.setId("77");
        student.setAge("77");
        student.setGid("77");
        student.setName("77");
        student.setSex("男");
        studentService.insertStudent(student);
        return "SUCCESS";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(String id){
        studentService.deleteStudent(id);
        return "SUCCESS";
    }

    /**
     * 修改
     * 修改跟添加调用的是同一个方法如果id相同就改变数据没有就创建数据
     * @param student
     * @return
     */
    @RequestMapping("update")
    public String update(Student student){
        studentService.updateStudent(student);
        return "SUCCESS";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("studentId")
    public Student getStudentById(String id){
        return studentService.getStudentById(id);
    }

}
