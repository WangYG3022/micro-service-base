package micro.service.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 服务提供方、Eureka客户端主启动类
 * @author: WANG Y.G.
 * @time: 2020/07/25 20:47
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
@MapperScan("micro.service.cloud.mapper")
public class ProviderDeptApp8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptApp8002.class, args);
    }
}
