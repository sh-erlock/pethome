package org.ethan.org.service;

import org.ethan.basic.service.IBaseService;
import org.ethan.basic.util.PageList;
import org.ethan.org.domain.Department;
import org.ethan.org.query.DepartmentQuery;

import java.util.List;

/**
 * @author Ethan Hunter
 */

public interface IDepartmentService extends IBaseService<Department> {



    /**
     * 查询部门树
     * @return
     */
    List<Department> queryTree();
}
