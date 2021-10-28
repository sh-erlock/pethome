package org.ethan.org.domain;

import lombok.Data;
import org.ethan.basic.domain.BaseDomain;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee extends BaseDomain {

    private String username;

    private String email;

    private String phone;

    private String salt;

    private String password;

    private Integer age;

    private Integer state;

    private Department department;

    private Long department_id;

    private Long logininfo_id;

    private Long shop_id;

    private List<Employee> children = new ArrayList<>();

    /**
     * 接收前端传来的二次确认密码，此字段在数据库中并不存在，只是为了校验用
     */
    private String confirmPassword;

}
