package com.web.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Gary on 2016/11/24.
 */
@Configuration
@ComponentScan(value="com.web",excludeFilters=@Filter(type = FilterType.ANNOTATION,
        value = {Controller.class, EnableWebMvc.class, ControllerAdvice.class}))
@Import({SpringServiceConfig.class,SpringDaoConfig.class})
public class SpringContextConfig {


}
