package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:10
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaClient // 服务消费端集成Eureka，作为Eureka的客户端
@EnableFeignClients(basePackages = "micro.service.cloud.service") // 启用Feign
public class ConsumerDeptFeignApp80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptFeignApp80.class, args);
    }
}


