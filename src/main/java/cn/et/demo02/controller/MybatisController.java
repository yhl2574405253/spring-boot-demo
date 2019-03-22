package cn.et.demo02.controller;

import cn.et.demo02.model.UserInfo;
import cn.et.demo02.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo02")
public class MybatisController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 添加
     * @param userInfo
     * @return
     */
    @RequestMapping("insert")
    public String insert(UserInfo userInfo){
        userInfoService.insert(userInfo);
        return "SUCCESS";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(String id){
        userInfoService.delete(id);
        return "SUCCESS";
    }

    /**
     * 修改
     * @param userInfo
     * @return
     */
    @RequestMapping("update")
    public String update(UserInfo userInfo){
        userInfoService.update(userInfo);
        return "SUCCESS";
    }

    /**
     * 查询素有的数据
     * @return
     */
    @RequestMapping("getUserInfo")
    public List<UserInfo> getUserInfo(){
        return userInfoService.getUserInfo();
    }

    /**
     * 根据条件查询
     * @param userInfo
     * @return
     */
    @RequestMapping("getUserInfoQuery")
    public List<UserInfo> getUserInfoQuery(UserInfo userInfo){
        return userInfoService.getUserInfoQuery(userInfo);
    }

    /**
     * 根据id查询单个
     * @param id
     * @return
     */
    @RequestMapping("getUserInfoOne")
    public UserInfo getUserInfoOne(String id){
        return userInfoService.getUserInfoOne(id);
    }
}
