package org.ethan.org.service;

import org.ethan.basic.service.IBaseService;
import org.ethan.basic.util.PageList;
import org.ethan.org.domain.Department;
import org.ethan.org.domain.Employee;
import org.ethan.org.query.EmployeeQuery;

import java.util.List;

/**
 * @author Ethan Hunter
 */

public interface IEmployeeService extends IBaseService<Employee> {

    /**
     * 查询员工树
     * @return
     */
    List<Employee> queryTree();
}
