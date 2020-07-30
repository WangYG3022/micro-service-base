package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/29 22:30
 * @version: V1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApp9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApp9527.class, args);
    }

}
