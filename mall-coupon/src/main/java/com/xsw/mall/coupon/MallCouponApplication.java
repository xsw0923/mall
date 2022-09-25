package com.xsw.mall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.如何使用Nacos作为配置中心统一管理
 *      1）引入依赖
 *      2）创建一个bootstrap.properties
 *      spring.application.name=mall-coupon
 *      spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *      3）需要给配置中心添加一个 叫数据集，默认规则id：应用名.properties
 *      4)给数据集添加配置
 *      5）动态获取配置
 *          @RefreshScope：动态获取并刷新配置
 *          @Value("${配置项的名}")：获取到配置
 *          如果配置中心和当前应用的配置文件都配置了相同的项，优先使用配置中心的配置
 * 2、细节
 *  1）命名空间：配置隔离；
 *      默认：public（保留空间）：默认新增的所有配置都在public中
 *      1、开发，测试，上线：利用命名空间来做环境隔离
 *          注意：在bootstrap.properties配置中指定命名空间
 *          spring.cloud.nacos.config.namespace=id
 *      2.每一个微服务之间互相隔离，每一个微服务都创建自己的命名空间，只加载自己的命名空间下的所有配置
 *
 *  2）配置集：所有配置的集合
 *
 *  3）配置节ID：类似于配置文件名
 *  Data ID
 *
 *  4）配置分组
 *      默认所有的配置集都属于：DEFAULT_GROUP
 *      spring.cloud.nacos.config.group=指定组名
 *    每个微服务都有自己的命名空间，利用分组来区分环境：dev,test,prod
 *
 * 3.同时加载多个配置集
 *  1)微服务任何配置信息，任何配置文件都可以放到配置中心中
 *  2）只需要在bootstrap.properties说明加载配置中心的哪些配置文件即可
 *  3）@Vaue("")@ConfigurationProperties
 *  以前springboot任何方法从配置文件中获取值，都能使用
 *  配置中心有的优先使用配置中心的
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponApplication.class, args);
    }

}
