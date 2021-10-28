package org.ethan.system.service.impl;

import org.ethan.basic.service.impl.BaseServiceImpl;
import org.ethan.system.domain.SystemDictionaryDetail;
import org.ethan.system.domain.SystemDictionaryType;
import org.ethan.system.mapper.SystemDictionaryDetailMapper;
import org.ethan.system.service.ISystemDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class SystemDictionaryTypeServiceImpl extends BaseServiceImpl<SystemDictionaryType> implements ISystemDictionaryTypeService {

    @Autowired
    private SystemDictionaryDetailMapper mapper;

    @Override
    public void del(Long id) {

        // 根据字典id查询明细,删除
        List<SystemDictionaryDetail> details = mapper.loadByTypeId(id);

        List<Long> ids = new ArrayList<>(details.size());
        if(details.size()!=0){
            for (SystemDictionaryDetail detail : details) {
                ids.add(0, detail.getId());
            }
            // 删除

            mapper.patchDelete(ids);
        }
        super.del(id);
    }

    @Override
    public void patchDel(List<Long> ids) {

        // 根据ids查询 所有的明细
        List<SystemDictionaryDetail> details =  mapper.loadByIds(ids);
        Long[] dbIds = new Long[details.size()];
        if(details.size()!=0){
            for(int i=0;i<details.size();i++){
                dbIds[i] = details.get(i).getId();
            }
            // 删除
            mapper.patchDelete(ids);
        }

        super.patchDel(ids);
    }

}
