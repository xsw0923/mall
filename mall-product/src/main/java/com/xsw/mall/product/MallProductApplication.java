package com.xsw.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  1.整合MyBatis-plus
 *      1)导入依赖
 *      2）配置
 *          1.配置数据源
 *              1)导入数据库驱动
 *              2）在application.yml中配置数据源相关信息
 *          2.配置MyBatis-Plus：
 *              1）使用MapperScan
 *              2）告诉mybatis-plus，sql映射文件位置
 *   2、逻辑删除
 *      1)配置全局的逻辑删除的规则
 *      mybatis-plus:
 *         global-config:
 *          db-config:
 *              logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
 *              logic-delete-value: 1 # 逻辑已删除值(默认为 1)
 *              logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
 *       2）配置逻辑删除的组件（3.1.0版本之后可省略）
 *       3）给实体类的字段上加上@TableLogic注解
 *       @TableLogic
 *       private Integer deleted;
 *
 *     3、JSR303
 *      1)、给Bean添加校验注解，并可以定义自己的message提示
 *      2)、开启校验功能 @Valid
 *          效果：校验错误之后，会有默认的响应
 *      3)、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *      4）分组校验
 *          1）@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *          给校验注解标注什么情况需要进行校验
 *          2）@Validated({AddGroup.class})
 *          3）默认没有指定分组的校验注解@NotBlank，在分组校验情况下不生效，只会在不分组@Validated下生效
 *      5）自定义校验
 *          1.编写一个自定义的校验注解
 *          2.编写一个自定义的校验器
 *          3.关联自定义的校验器和自定义的校验注解
 *          @Documented
 *          @Constraint(validatedBy = { ListValueConstraintValidator.class 【可以指定多个不同的校验器，适配不同类型的校验】})
 *          @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
 *          @Retention(RUNTIME)
 *      4.统一的异常处理
 * @ControllerAdvice
 * 1)编写异常处理类，使用@ControllerAdvice
 * 2）使用@ExceptionHandle标注方法可以处理的异常
 */
@MapperScan("com.xsw.mall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xsw.mall.product.feign")
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
