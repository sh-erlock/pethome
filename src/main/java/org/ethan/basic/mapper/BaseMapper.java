package org.ethan.basic.mapper;

import org.ethan.basic.query.BaseQuery;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;
@Repository
public interface BaseMapper<T> {
    /**
     * 查询一条数据
     * @param id
     * @return
     */
    T selectOneById(Long id);

    /**
     * 查询所有数据
     * @return
     */
    List<T> selectAll();

    /**
     * 添加一条数据
     * @param t
     */
    void add(T t);

    /**
     * 修改一条数据
     * @param t
     */
    void update(T t);

    /**
     * 根据id删除一条数据
     * @param id
     */
    void delete(Long id);

    /**
     * 查询分页的数据条数
     * @param query
     * @return
     */
    Integer queryCounts(BaseQuery query);

    /**
     * 查询分页的数据，高级查询
     * @param query
     * @return
     */
    List<T> queryData(BaseQuery query);

    /**
     * 批量删除
     * @param ids
     */
    void patchDelete(List<Long> ids);

}
