package cn.et.demo02.service.impl;

import cn.et.demo02.mapper.UserInfoMapper;
import cn.et.demo02.model.UserInfo;
import cn.et.demo02.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoSeriviceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public void insert(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void delete(String id) {
        userInfoMapper.delete(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }

    @Override
    public List<UserInfo> getUserInfo() {
        return userInfoMapper.getUserInfo();
    }

    @Override
    public List<UserInfo> getUserInfoQuery(UserInfo userInfo) {
        return userInfoMapper.getUserInfoQuery(userInfo);
    }

    @Override
    public UserInfo getUserInfoOne(String id) {
        return userInfoMapper.getUserInfoOne(id);
    }
}
