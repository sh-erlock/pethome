package org.ethan.org.mapper;

import org.ethan.basic.mapper.BaseMapper;
import org.ethan.org.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ethan Hunter
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {


    /**
     * 查询员工树
     * @return
     */
    List<Employee> findTree();

    /**
     * 根据username查询数据
     * @param username
     * @return
     */
    Employee findByUsername(String username);
}
