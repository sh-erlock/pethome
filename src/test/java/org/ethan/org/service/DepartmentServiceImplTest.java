package org.ethan.org.service;

import org.ethan.BaseTest;
import org.ethan.basic.util.PageList;
import org.ethan.org.domain.Department;
import org.ethan.org.query.DepartmentQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest extends BaseTest {

    @Autowired
    private IDepartmentService service;

    /*@Test
    public void add() {
        service.add(new Department(null, "dept1", "部门10", "/1", 0, 324L, 17L));
    }*/

   /* @Test
    public void update() {
        service.update(new Department(46L, "dept2", "部门1", "/1", 0, 324L, 17L));
    }*/

    @Test
    public void del() {
        service.del(45L);
    }

    @Test
    public void getById() {
        Department department = service.getById(5L);
        System.out.println(department);
    }

    @Test
    public void getAll() {
        service.getAll().forEach(System.out::println);
    }

   /* @Test
    public void queryData() {
        // 给予分页查询条件
        DepartmentQuery query = new DepartmentQuery(5, 5);

        // 调用方法传入查询条件
        PageList<Department> pageList = service.queryData(query);

        // 打印查询出的数据总条数
        System.out.println("数据总条数：" + pageList.getTotals());

        System.out.println("显示：");

        // 打印查询出的数据
        pageList.getList().forEach(System.out::println);

    }*/
}