package micro.service.cloud.service;

import feign.hystrix.FallbackFactory;
import micro.service.cloud.entity.Department;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/28 22:49
 * @version: V1.0
 */
@Component // 一定不要忘记加注解
public class DepartmentFeignFallbackFactory implements FallbackFactory<DepartmentFeign> {

    @Override
    public DepartmentFeign create(Throwable throwable) {
        return new DepartmentFeign() {

            @Override
            public boolean add(Department department) {
                return false;
            }

            @Override
            public List<Department> list() {
                return Collections.emptyList();
            }

            @Override
            public Department get(Long id) {
                Department department = new Department();
                department.setId(id);
                department.setDeptName("服务降级，查无数据。");
                return department;
            }
        };
    }
}
