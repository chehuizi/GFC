package com.bmf.api.validator;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.common.utils.ParamCheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("domainReqDTOValidator")
public class DomainReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4QueryOne(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusiness().getBusinessCode(), "business code is null");
        return true;
    }

    /**
     * 校验create方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4Create(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkBlank(domainReqDTO.getBusinessDomain().getDomainName(), "domain name is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getBusinessDomain().getDomainAlias(), "domain alias is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getBusinessDomain().getDomainType(), "domain type is blank");
        ParamCheckUtil.checkTrue(BusinessDomainTypeEnum.contain(domainReqDTO.getBusinessDomain().getDomainType()), "domain type is illegal");
        ParamCheckUtil.checkTrue(BusinessDomainLevelEnum.contain(domainReqDTO.getBusinessDomain().getDomainLevel()), "domain level is illegal");
        return true;
    }

    /**
     * 校验update方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4Update(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(domainReqDTO.getBusinessDomain().getDomainCode()) ||
                StringUtils.isNotBlank(domainReqDTO.getBusinessDomain().getDomainAlias()),
                "domain code is null && domain alias is blank");
        return true;
    }

    /**
     * 校验delete方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4Delete(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkBlank(domainReqDTO.getBusinessDomain().getDomainAlias(), "domain alias is blank");
        return true;
    }
}
