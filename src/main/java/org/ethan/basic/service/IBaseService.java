package org.ethan.basic.service;

import org.ethan.basic.query.BaseQuery;
import org.ethan.basic.util.PageList;

import java.util.List;

public interface IBaseService<T> {

    void add(T t);

    void update(T t);

    void del(Long id );

    T getById(Long id );

    List<T> getAll();

    /*
     分页查询
     */
    PageList<T> queryData(BaseQuery query);

    /**
     * 批量删除
     * @param ids
     */
    void patchDel(List<Long> ids);

}
