package org.ethan.org.domain;

import lombok.Data;
import org.ethan.basic.domain.BaseDomain;

import java.util.Date;

@Data
public class Shop extends BaseDomain {
    private String name;
    private String tel;
    private Date registerTime = new Date();
    // 审核状态：0待审核 1审核通过 2驳回 -1拒绝
    private Integer state = 0;
    private String address;
    private String logo;
    private Employee admin;
}