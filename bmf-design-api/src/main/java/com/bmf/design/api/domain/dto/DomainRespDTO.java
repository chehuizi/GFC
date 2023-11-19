package com.bmf.design.api.domain.dto;

import com.bmf.common.api.RespDTO;
import com.bmf.design.model.Domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    private Domain domain;

    public DomainRespDTO(Domain domain) {
        this.domain = domain;
    }

}
