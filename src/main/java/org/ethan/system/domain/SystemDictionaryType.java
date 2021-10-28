package org.ethan.system.domain;

import lombok.Data;
import org.ethan.basic.domain.BaseDomain;

@Data
public class SystemDictionaryType extends BaseDomain {

    private String sn;
    private String name;
}
