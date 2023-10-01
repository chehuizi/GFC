package com.bmf.design.api.domain.dto;

import com.bmf.design.api.ReqDTO;
import com.bmf.design.base.tactics.valueobject.DomainValueObject;
import com.bmf.design.base.tactics.valueobject.DomainValueObjectAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域值对象请求对象
 */
@Data
public class DomainValueObjectReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 2597196606070191312L;

    /**
     * 值对象
     */
    private DomainValueObject domainValueObject;
    /**
     * 值对象属性
     */
    private DomainValueObjectAttr valueObjectAttr;
}
