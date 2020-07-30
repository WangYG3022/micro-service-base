package micro.service.cloud.consumer;

import micro.service.cloud.rule.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:10
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaClient // 服务消费端集成Eureka，作为Eureka的客户端
@RibbonClient(name = "MS-CLOUD-DEPT", configuration = RibbonRuleConfig.class) // 对比@RibbonClients，可以为每个微服务指定负载均衡算法
public class ConsumerDeptApp80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptApp80.class, args);
    }
}
