package micro.service.cloud.service;

import micro.service.cloud.entity.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/28 20:44
 * @version: V1.0
 */
@RequestMapping("/p/dept") // 与服务提供方的URI保持一致
//@FeignClient("MS-CLOUD-DEPT")
@FeignClient(value = "MS-CLOUD-DEPT", fallbackFactory = DepartmentFeignFallbackFactory.class)
public interface DepartmentFeign {

    @PostMapping(path = "/add")
    boolean add(@RequestBody Department department);

    @GetMapping("/list")
    List<Department> list();

    /**
     * 注意：@PathVariable必须带value值，否则Feign会报错：PathVariable annotation was empty on param 0.
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    Department get(@PathVariable("id") Long id);

}

