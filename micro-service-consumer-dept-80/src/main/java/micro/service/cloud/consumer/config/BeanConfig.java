package micro.service.cloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:00
 * @version: V1.0
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced // Ribbon客户端负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
