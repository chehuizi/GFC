package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainReqDTO;
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
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(domainReqDTO.getBusinessDomain().getDomainCode()) ||
                        StringUtils.isNotBlank(domainReqDTO.getBusinessDomain().getDomainAlias()),
                "domain code is null && domain alias is blank");
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

    /**
     * 校验addEntity方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4AddEntity(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getBusinessDomain().getDomainCode().equals(
                domainReqDTO.getDomainEntity().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEntity().getEntityIdAlias(), "domain entity id alias is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEntity().getEntityIdName(), "domain entity id name is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEntity().getEntityIdType(), "domain entity id type is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEntity().getEntityDesc(), "domain entity desc is blank");
        return true;
    }

    /**
     * 校验delEntity方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4DelEntity(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        return true;
    }

    /**
     * 校验addService方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4AddService(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getBusinessDomain().getDomainCode().equals(
                domainReqDTO.getDomainService().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainService().getServiceAlias(), "domain service alias is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainService().getServiceName(), "domain service name is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainService().getServiceDesc(), "domain service desc is blank");
        return true;
    }

    /**
     * 校验delService方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4DelService(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainService().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainService().getServiceCode(), "domain service code is null");
        return true;
    }

    /**
     * 校验addValueObject方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4AddValueObject(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getBusinessDomain().getDomainCode().equals(
                domainReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainValueObject().getVoAlias(), "domain value object alias is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainValueObject().getVoName(), "domain value object name is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainValueObject().getVoDesc(), "domain value object desc is blank");
        return true;
    }

    /**
     * 校验delValueObject方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4DelValueObject(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        return true;
    }

    /**
     * 校验addDomainEvent方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4AddDomainEvent(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getBusinessDomain().getDomainCode().equals(
                domainReqDTO.getDomainEvent().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEvent().getEventAlias(), "domain event alias is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEvent().getEventName(), "domain event name is blank");
        ParamCheckUtil.checkBlank(domainReqDTO.getDomainEvent().getEventDesc(), "domain event desc is blank");
        return true;
    }

    /**
     * 校验delDomainEvent方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4DelDomainEvent(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEvent().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEvent().getEventCode(), "domain event code is null");
        return true;
    }

    /**
     * 校验addEntityRelVO方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4AddEntityRelVO(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getDomainEntity().getDomainCode().equals(
                domainReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        return true;
    }

    /**
     * 校验delEntityRelVO方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4DelEntityRelVO(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        ParamCheckUtil.checkTrue(domainReqDTO.getDomainEntity().getDomainCode().equals(
                domainReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        return true;
    }
}
