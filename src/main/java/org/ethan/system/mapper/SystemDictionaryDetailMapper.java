package org.ethan.system.mapper;

import org.ethan.basic.mapper.BaseMapper;
import org.ethan.system.domain.SystemDictionaryDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemDictionaryDetailMapper extends BaseMapper<SystemDictionaryDetail> {

    List<SystemDictionaryDetail> loadByTypeId(Long id);

    List<SystemDictionaryDetail> loadByIds(List<Long> ids);
}
