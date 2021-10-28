package org.ethan.system.service;

import org.ethan.basic.service.IBaseService;
import org.ethan.system.domain.SystemDictionaryDetail;

import java.util.List;

public interface ISystemDictionaryDetailService extends IBaseService<SystemDictionaryDetail> {

    List<SystemDictionaryDetail> loadByTypeId(Long id);

}
