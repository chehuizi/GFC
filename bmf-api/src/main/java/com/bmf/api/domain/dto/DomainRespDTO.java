package com.bmf.api.domain.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.BusinessDomain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 领域返回对象
 */
@Data
@NoArgsConstructor
public class DomainRespDTO extends RespDTO implements Serializable {

    private static final long serialVersionUID = 901088274232700187L;

    /**
     * 业务领域
     */
    private BusinessDomain businessDomain;

    /**
     * 业务领域列表
     */
    private List<BusinessDomain> businessDomainList;

    public DomainRespDTO(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }

}
