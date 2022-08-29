package cn.itcast.user;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.itcast.user.dao")
public class PlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class,args);
    }
}
