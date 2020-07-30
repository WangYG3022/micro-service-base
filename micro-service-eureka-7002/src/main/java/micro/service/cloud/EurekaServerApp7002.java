package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:39
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类
public class EurekaServerApp7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp7002.class, args);
    }
}
