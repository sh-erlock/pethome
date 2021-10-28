package org.ethan.org.service.impl;

import org.ethan.basic.service.impl.BaseServiceImpl;

import org.ethan.org.domain.Employee;
import org.ethan.org.mapper.EmployeeMapper;

import org.ethan.org.service.IEmployeeService;
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
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper mapper;



    /**
     * 查询员工树
     * @return
     */
    @Override
    public List<Employee> queryTree() {
        return mapper.findTree();
    }
}
