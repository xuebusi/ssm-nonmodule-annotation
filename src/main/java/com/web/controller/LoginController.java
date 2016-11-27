package com.web.controller;

import com.web.dao.domain.UserInfo;
import com.web.service.FindAllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Gary on 2016/11/24.
 */
@Controller
public class LoginController {

    @Autowired
    private FindAllUserService findAllUserService;

    @ResponseBody
    @RequestMapping("/getAllUsers")
    public String getAllUsers(){
        List<UserInfo> userInfoList = findAllUserService.findAllUserInfos();

        for(UserInfo userInfo:userInfoList){
            System.out.println(userInfo.getId() + ":" + userInfo.getUsername());
        }

        return "find success!";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(UserInfo userInfo){
        System.out.println(findAllUserService.insertUserInfo(userInfo));
        return "insert success!";
    }

}
