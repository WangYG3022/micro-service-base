package micro.service.cloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 实现自定义Ribbon轮询算法，每个节点提供服务5次后，轮询下一节点
 * @author: WANG Y.G.
 * @time: 2020/07/28 18:12
 * @version: V1.0
 */
public class Round5RibbonRule extends AbstractLoadBalancerRule {

    /**
     * 每个节点轮训次数阈值：5次
     */
    private static final int THRESHOLD = 5;
    /**
     * 当前节点的提供服务次数
     */
    private AtomicInteger times = new AtomicInteger(0);
    /**
     * 当前服务节点的索引
     */
    private AtomicInteger currentServerIdx = new AtomicInteger(0);

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                // 当前节点服务次数小于5次
                if (times.incrementAndGet() <= THRESHOLD) {
                    server = upList.get(currentServerIdx.get());
                } else {
                    // 当前节点提供服务超过5次，节点索引加1，若果超过最大索引，则置为0，从头开始
                    if (currentServerIdx.incrementAndGet() >= upList.size()) {
                        currentServerIdx.set(0);
                    }
                    server = upList.get(currentServerIdx.get());
                    // 重置服务次数
                    times.compareAndSet(THRESHOLD + 1, 1);
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
