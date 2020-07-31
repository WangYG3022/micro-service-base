package micro.service.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/30 21:28
 * @version: V1.0
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public Map<String, String> getConfig() {
        Map<String, String> config = new HashMap<>(8);
        config.put("applicationName", applicationName);
        config.put("eurekaServers", eurekaServers);
        config.put("port", port);
        config.keySet().forEach(s -> System.out.println("key=" + s + ", value=" + config.get(s)));
        return config;
    }

}
