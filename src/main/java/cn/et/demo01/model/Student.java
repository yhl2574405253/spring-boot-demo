package cn.et.demo01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//@Entity用来标识这是一个实体类
@Entity
public class Student {
   //@Id  hibernate的特征，必须要一个id不然会报错
    @Id
    //@Column(name = "sid") 用来跟表的字段做个映射，如果名字相同就不需要写
    @Column(name = "sid")
    private String id;

    @Column(name = "sname")
    private String name;

    @Column(name = "gid")
    private String gid;

    @Column(name = "sage")
    private String age;

    @Column(name = "ssex")
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
