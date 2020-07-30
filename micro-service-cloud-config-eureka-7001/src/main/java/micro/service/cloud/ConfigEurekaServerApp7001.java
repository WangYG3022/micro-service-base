package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: Spring Cloud Config版的Eureka服务端
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:39
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigEurekaServerApp7001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServerApp7001.class, args);
    }
}
