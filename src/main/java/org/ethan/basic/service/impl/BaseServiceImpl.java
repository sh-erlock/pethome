package org.ethan.basic.service.impl;

import org.ethan.basic.mapper.BaseMapper;
import org.ethan.basic.query.BaseQuery;
import org.ethan.basic.service.IBaseService;
import org.ethan.basic.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.List;


@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;

    @Override
    @Transactional
    public void add(T t) {
        mapper.add(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        mapper.update(t);
    }

    @Override
    @Transactional
    public void del(Long id) {
        mapper.delete(id);
    }

    @Override
    public T getById(Long id) {
        return mapper.selectOneById(id);
    }

    @Override
    public List<T> getAll() {
        return mapper.selectAll();
    }

    @Override
    public PageList<T> queryData(BaseQuery query) {
        // 总条数
        Integer totals = mapper.queryCounts(query);
        // 当前页数据
        List<T> rows = mapper.queryData(query);

        return new PageList<T>(totals,rows);

    }

    @Override
    @Transactional
    public void patchDel(List<Long> ids) {
        mapper.patchDelete(ids);
    }
}
