package cn.et.demo01.service.impl;

import cn.et.demo01.mapper.StudentMapper;
import cn.et.demo01.model.Student;
import cn.et.demo01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentMapper.delete(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return (List<Student>) studentMapper.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentMapper.findOne(id);
    }
}
