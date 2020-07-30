package micro.service.cloud.service.impl;

import micro.service.cloud.entity.Department;
import micro.service.cloud.mapper.DepartmentMapper;
import micro.service.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 20:39
 * @version: V1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department findById(Long id) {
        return departmentMapper.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    @Override
    public boolean addDept(Department department) {
        return departmentMapper.addDept(department);
    }
}
