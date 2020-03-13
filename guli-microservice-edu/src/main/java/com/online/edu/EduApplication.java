package com.online.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName EduApplication
 * @Description TODO
 * @Author User
 * @Date 2020/3/12 17:22
 * @Version 1.0
 * @Desc
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.online.edu","com.guli.common"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
