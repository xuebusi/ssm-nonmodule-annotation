package com.web.conf;

import com.web.dao.domain.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;

/**
 * Created by Gary on 2016/11/24.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(value = "com.web.dao",sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class SpringDaoConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource driverManagerDataSource(){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername(environment.getProperty("mysql.username"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("mysql.driver"));
        driverManagerDataSource.setPassword(environment.getProperty("mysql.password"));
        driverManagerDataSource.setUrl(environment.getProperty("mysql.url"));

        return driverManagerDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.driverManagerDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.web.dao.domain");
        Resource resource = new ClassPathResource("/mapper/userInfoMapper.xml");
        sqlSessionFactoryBean.setMapperLocations(new Resource[]{resource});

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager txManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.driverManagerDataSource());
        return dataSourceTransactionManager;
    }

//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return txManager();
//    }



}
