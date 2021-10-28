package org.ethan.org.service.impl;

import org.ethan.basic.service.impl.BaseServiceImpl;
import org.ethan.basic.util.PageList;
import org.ethan.org.domain.Department;
import org.ethan.org.mapper.DepartmentMapper;
import org.ethan.org.query.DepartmentQuery;
import org.ethan.org.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author Ethan Hunter
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public void add(Department department) {
        departmentMapper.add(department);

        /*if (department.getParent() == null) {
            department.setDirPath("/" + department.getId());
        } else {
            Department dept = departmentMapper.selectOneById(department.getParent().getId());
            department.setDirPath(dept.getDirPath() + "/" + department.getId());
        }*/

        update(department);

        /*System.out.println("添加成功！！！！！！！！！");*/
    }

    @Override
    @Transactional
    public void update(Department department) {

        if (department.getParent() == null || department.getParent().getId() == null) {
            department.setDirPath("/" + department.getId());
        } else {
            Department dept = departmentMapper.selectOneById(department.getParent().getId());
            department.setDirPath(dept.getDirPath() + "/" + department.getId());
        }

        departmentMapper.update(department);
        System.out.println("修改成功！！！！！！！！！");

    }


    @Override
    public List<Department> queryTree() {
        return departmentMapper.findTree();
    }
}
