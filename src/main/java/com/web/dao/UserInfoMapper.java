package com.web.dao;


import com.web.dao.domain.UserInfo;

import java.util.List;

/**
 * Created by Gary on 2016/11/18.
 */
public interface UserInfoMapper {
    public List<UserInfo> findAllUsers();
    public int insertUserInfo(UserInfo userInfo);
}
