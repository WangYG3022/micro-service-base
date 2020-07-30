package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/29 23:55
 * @version: V1.0
 */
@SpringBootApplication
@EnableConfigServer // 配置中心服务端
public class ConfigServerApp3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp3344.class, args);
    }
}
