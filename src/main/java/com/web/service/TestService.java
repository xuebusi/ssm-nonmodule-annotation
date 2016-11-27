package com.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Gary on 2016/11/24.
 */
@Service
public class TestService {

    public String printInfo(){
        return "Hello World";
    }


}
