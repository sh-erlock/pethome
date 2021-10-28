package org.ethan.system.domain;

import lombok.Data;
import org.ethan.basic.domain.BaseDomain;

@Data
public class SystemDictionaryDetail extends BaseDomain {

    private String name;



    private SystemDictionaryType sdt;
}
