package micro.service.cloud.controller;

import micro.service.cloud.entity.Department;
import micro.service.cloud.service.DepartmentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DepartmentFeign departmentFeign;

    @PostMapping(path = "/add")
    public boolean add(@RequestBody Department department) {
        return departmentFeign.add(department);
    }

    @GetMapping("/list")
    public List<Department> list() {
        return departmentFeign.list();
    }

    @GetMapping("/get/{id}")
    public Department get(@PathVariable Long id) {
        return departmentFeign.get(id);
    }

}
