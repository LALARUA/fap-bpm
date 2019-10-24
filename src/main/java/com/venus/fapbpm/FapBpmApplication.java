package com.venus.fapbpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.venus.fapbpm.mapper")
@SpringBootApplication
public class FapBpmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FapBpmApplication.class, args);
    }

}
