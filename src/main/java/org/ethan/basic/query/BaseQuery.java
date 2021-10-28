package org.ethan.basic.query;

import lombok.Data;

@Data
public class BaseQuery {
    /**
     * 当前页，赋初值防止空指针异常
     */
    private Integer currentPage = 1;

    /**
     * 每一页显示的数据条数，赋初值防止空指针异常
     */
    private Integer pageSize = 5;

    /**
     * 高级查询的关键字
     */
    private String keyword;

    /**
     * 获取起始页
     * @return
     */
    public Integer getStartPage(){

        return (this.currentPage - 1) * this.pageSize;
    }

}
