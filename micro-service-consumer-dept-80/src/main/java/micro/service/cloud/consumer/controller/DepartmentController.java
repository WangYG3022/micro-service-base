package micro.service.cloud.consumer.controller;

import micro.service.cloud.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 22:12
 * @version: V1.0
 */
@RestController
@RequestMapping("/c/dept")
public class DepartmentController {

//    private static final String DEPT_REST_URL_PREFIX = "http://localhost:8001/p/dept";
    private static final String DEPT_REST_URL_PREFIX = "http://MS-CLOUD-DEPT/p/dept";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public boolean add(@RequestBody Department department) {
        return restTemplate.postForObject(DEPT_REST_URL_PREFIX + "/add", department, Boolean.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Department> list() {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX + "/list", List.class);
    }

    @GetMapping("/get/{id}")
    public Department get(@PathVariable Long id) {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX + "/get/" + id, Department.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX + "/discovery", Object.class);
    }
}
