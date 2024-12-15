package com.lordbao.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Lord_Bao
 * @Date 2024/12/6 16:21
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.lordbao.cloud.mapper")
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}
