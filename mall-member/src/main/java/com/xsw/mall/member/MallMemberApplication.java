package com.xsw.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  想要远程调用别的服务
 *      1)引入openfegin
 *      2）编写一个接口告诉springcloud这个接口需要调用远程服务
 *          1.声明每一个接口的方法都是调用哪个服务的哪个请求
 *      3）开启远程调用服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xsw.mall.member.fegin")
public class MallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }

}
