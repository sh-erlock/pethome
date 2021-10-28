package org.ethan.org.mapper;

import org.ethan.basic.mapper.BaseMapper;
import org.ethan.org.domain.Department;
import org.ethan.org.query.DepartmentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ethan Hunter
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {


    /**
     * 查询部门树
     * @return
     */
    List<Department> findTree();
}
