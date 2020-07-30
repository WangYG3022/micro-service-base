package micro.service.cloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: WANG Y.G.
 * @time: 2020/07/25 19:01
 * @version: V1.0
 */
@Data
public class Department implements Serializable {

    private Long id;
    private String deptName;
    private String dbSource;

}
