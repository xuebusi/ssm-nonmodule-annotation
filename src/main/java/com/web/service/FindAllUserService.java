package com.web.service;

import com.web.dao.UserInfoMapper;
import com.web.dao.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Gary on 2016/11/26.
 */
@Service
public class FindAllUserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional
    public List<UserInfo> findAllUserInfos(){
        return this.userInfoMapper.findAllUsers();
    }

    @Transactional
    public int insertUserInfo(UserInfo userInfo){
        return userInfoMapper.insertUserInfo(userInfo);
    }


}
