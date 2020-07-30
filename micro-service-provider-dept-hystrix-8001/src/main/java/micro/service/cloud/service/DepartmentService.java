package micro.service.cloud.service;

import micro.service.cloud.entity.Department;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 20:36
 * @version: V1.0
 */
public interface DepartmentService {

    Department findById(Long id);

    List<Department> findAll();

    boolean addDept(Department department);
}
