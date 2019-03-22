package cn.et.demo02.mapper;

import cn.et.demo02.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Mapper
public interface UserInfoMapper {
    /**
     * 添加
     * @param userInfo
     */
    @Insert("insert into userInfo (uid,uname,uage,usex) VALUE(#{userInfo.id},#{userInfo.name},#{userInfo.age},#{userInfo.sex})")
    void insert(@Param("userInfo") UserInfo userInfo);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from userInfo where uid=#{id}")
    void delete(@Param("id") String id);

    /**
     * 修改
     * @param userInfo
     */
    void update(@Param("userInfo") UserInfo userInfo);

    /**
     * 查询所有
     * @return
     */
    @Results({
        @Result(column = "uid",property = "id"),
        @Result(column = "uname",property = "name"),
        @Result(column = "uage",property = "age"),
        @Result(column = "usex",property = "sex")
    })
    @Select("select * from userInfo")
    List<UserInfo> getUserInfo();

    /**
     * 根据条件查询
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoQuery(@Param("userInfo") UserInfo userInfo);

    /**
     * 根据id查询单个
     * @param id
     * @return
     */
    UserInfo getUserInfoOne(@Param("id") String id);
}
