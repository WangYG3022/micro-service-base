package micro.service.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//    @Autowired
//    private DiscoveryClient client;

    @PostMapping(path = "/add")
    public boolean add(@RequestBody Department department) {
        return departmentService.addDept(department);
    }

    @GetMapping("/list")
    public List<Department> list() {
        return departmentService.findAll();
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrixGet") // 一旦调用方法失败并抛出异常后，会调用fallbackMethod标注的指定方法处理
    public Department get(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id);
        // 模拟服务调用出现错误的情况
        if (department == null) {
            throw new RuntimeException("没有查到编号为" + id +"的部门信息");
        }
        return department;
    }

    /**
     * 熔断处理方法
     * @param id
     * @return
     */
    public Department processHystrixGet(@PathVariable("id") Long id) {
        Department department = new Department();
        department.setId(id);
        department.setDeptName("查无数据。（Hystrix-null）");
        department.setDbSource("no data");
        return department;
    }

}
