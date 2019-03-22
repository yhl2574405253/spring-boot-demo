package cn.et.demo01.mapper;

import cn.et.demo01.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentMapper extends CrudRepository<Student,String> {}
