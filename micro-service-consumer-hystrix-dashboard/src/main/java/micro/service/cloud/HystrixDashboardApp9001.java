package micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/29 21:36
 * @version: V1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp9001.class, args);
    }

}
