package org.ethan.org.domain;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;
import org.ethan.basic.domain.BaseDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethan Hunter
 * @Data ：此注解来自lombok，用于生成对应的getter， setter， toString方法
 */
@Data
public class Department extends BaseDomain {

    private String sn;

    private String name;

    private String dirPath;

    private Integer state;

    private Long manager_id;

    private Employee manager; // 使用对象传值

    private Long parent_id;

    private Department parent; // 使用对象传值

    private List<Department> children = new ArrayList<>();
    /*public Department(Long id, String sn, String name, String dirPath, Integer state, Long manager_id, Long parent_id) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.dirPath = dirPath;
        this.state = state;
        this.manager_id = manager_id;
        this.parent_id = parent_id;
    }

    public Department(Long id, String sn, String name, String dirPath, Integer state, Long manager_id, Employee manager, Long parent_id, Department parent) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.dirPath = dirPath;
        this.state = state;
        this.manager_id = manager_id;
        this.manager = manager;
        this.parent_id = parent_id;
        this.parent = parent;
    }*/
}
