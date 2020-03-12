package com.online.edu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName EduServiceConfig
 * @Description TODO
 * @Author User
 * @Date 2020/3/12 18:51
 * @Version 1.0
 * @Desc
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.online.edu.mapper")
public class EduServiceConfig {

}
