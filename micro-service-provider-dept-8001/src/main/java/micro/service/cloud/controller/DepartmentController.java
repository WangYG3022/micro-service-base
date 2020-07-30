package micro.service.cloud.controller;

import micro.service.cloud.entity.Department;
import micro.service.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 20:40
 * @version: V1.0
 */
@RestController
@RequestMapping("/p/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping(path = "/add")
    public boolean add(@RequestBody Department department) {
        return departmentService.addDept(department);
    }

    @GetMapping("/list")
    public List<Department> list() {
        return departmentService.findAll();
    }

    @GetMapping("/get/{id}")
    public Department get(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MS-CLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
