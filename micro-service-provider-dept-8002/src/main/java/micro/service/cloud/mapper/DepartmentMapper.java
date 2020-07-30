package micro.service.cloud.mapper;

import micro.service.cloud.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 20:25
 * @version: V1.0
 */
@Repository
public interface DepartmentMapper {

    Department findById(Long id);

    List<Department> findAll();

    boolean addDept(Department department);
}
