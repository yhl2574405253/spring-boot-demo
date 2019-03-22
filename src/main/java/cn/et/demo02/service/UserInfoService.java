package cn.et.demo02.service;

import cn.et.demo02.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 添加
     * @param userInfo
     */
    void insert(UserInfo userInfo);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 修改
     * @param userInfo
     */
    void update(UserInfo userInfo);

    /**
     * 查询所有
     * @return
     */
    List<UserInfo> getUserInfo();

    /**
     * 根据条件查询
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoQuery(UserInfo userInfo);

    /**
     * 根据id查询单个
     * @param id
     * @return
     */
    UserInfo getUserInfoOne(String id);
}
