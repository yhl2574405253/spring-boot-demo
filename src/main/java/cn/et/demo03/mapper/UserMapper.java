package cn.et.demo03.mapper;

import cn.et.demo03.model.UserInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface UserMapper {
    @Select("select * from t_user_info where name=#{userName}")
    UserInfoModel getUserByUserName(@Param("userName") String userName);

    @Select("SELECT t3.name FROM t_user_info t1\n" +
            "\tINNER JOIN t_user_role t2 ON t1.id=t2.user_id\n" +
            "\tINNER JOIN t_role_info t3 ON t3.id=t2.role_id \n" +
            "WHERE t1.NAME=#{userName}")
    Set<String> getRoleByUserName(@Param("userName") String userName);
}
