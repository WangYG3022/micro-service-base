package micro.service.cloud.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Ribbon负载均衡策略实现类
 *    官方明确规定：该自定义配置类不能放在@ComponentScan所扫描的当前包及子包下，否则会被所有客户端所共享
 * @author: WANG Y.G.
 * @time: 2020/07/28 0:04
 * @version: V1.0
 */
@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule iRule() {
//        return new RoundRobinRule();
        // 替换为自定义的轮询策略
        return new Round5RibbonRule();
    }
}
