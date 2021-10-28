package org.ethan.system.service.impl;

import org.ethan.basic.service.impl.BaseServiceImpl;
import org.ethan.system.domain.SystemDictionaryDetail;
import org.ethan.system.mapper.SystemDictionaryDetailMapper;
import org.ethan.system.service.ISystemDictionaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class SystemDictionaryDetailServiceImpl extends BaseServiceImpl<SystemDictionaryDetail> implements ISystemDictionaryDetailService {

    @Autowired
    private SystemDictionaryDetailMapper mapper;



    @Override
    public List<SystemDictionaryDetail> loadByTypeId(Long id) {

        return mapper.loadByTypeId(id);
    }


}
