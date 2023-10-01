package com.bmf.design.api.validator;

import com.bmf.design.api.domain.dto.DomainCmdReqDTO;
import com.bmf.design.base.enums.DomainLevelEnum;
import com.bmf.design.base.enums.DomainTypeEnum;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("domainCmdReqDTOValidator")
public class DomainCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4Create(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomain().getDomainName(), "domain name is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomain().getDomainAlias(), "domain alias is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomain().getDomainType(), "domain type is blank");
        ParamCheckUtil.checkTrue(DomainTypeEnum.contain(domainCmdReqDTO.getDomain().getDomainType()), "domain type is illegal");
        ParamCheckUtil.checkTrue(DomainLevelEnum.contain(domainCmdReqDTO.getDomain().getDomainLevel()), "domain level is illegal");
        return true;
    }

    /**
     * 校验update方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4Update(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(domainCmdReqDTO.getDomain().getDomainCode()) ||
                StringUtils.isNotBlank(domainCmdReqDTO.getDomain().getDomainAlias()),
                "domain code is null && domain alias is blank");
        return true;
    }

    /**
     * 校验delete方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4Delete(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomain().getDomainAlias(), "domain alias is blank");
        return true;
    }

    /**
     * 校验addEntity方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4AddEntity(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomain().getDomainCode().equals(
                domainCmdReqDTO.getDomainEntity().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEntity().getEntityIdAlias(), "domain entity id alias is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEntity().getEntityIdName(), "domain entity id name is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEntity().getEntityIdType(), "domain entity id type is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEntity().getEntityDesc(), "domain entity desc is blank");
        return true;
    }

    /**
     * 校验delEntity方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4DelEntity(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        return true;
    }

    /**
     * 校验addService方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4AddService(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomain().getDomainCode().equals(
                domainCmdReqDTO.getDomainService().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainService().getServiceAlias(), "domain service alias is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainService().getServiceName(), "domain service name is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainService().getServiceDesc(), "domain service desc is blank");
        return true;
    }

    /**
     * 校验delService方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4DelService(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainService().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainService().getServiceCode(), "domain service code is null");
        return true;
    }

    /**
     * 校验addValueObject方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4AddValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomain().getDomainCode().equals(
                domainCmdReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainValueObject().getVoAlias(), "domain value object alias is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainValueObject().getVoName(), "domain value object name is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainValueObject().getVoDesc(), "domain value object desc is blank");
        return true;
    }

    /**
     * 校验delValueObject方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4DelValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        return true;
    }

    /**
     * 校验addDomainEvent方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4AddDomainEvent(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomain().getDomainCode().equals(
                domainCmdReqDTO.getDomainEvent().getDomainCode()), "domain code is not equal");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEvent().getEventAlias(), "domain event alias is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEvent().getEventName(), "domain event name is blank");
        ParamCheckUtil.checkBlank(domainCmdReqDTO.getDomainEvent().getEventDesc(), "domain event desc is blank");
        return true;
    }

    /**
     * 校验delDomainEvent方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4DelDomainEvent(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEvent().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEvent().getEventCode(), "domain event code is null");
        return true;
    }

    /**
     * 校验addEntityRelVO方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4AddEntityRelVO(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomainEntity().getDomainCode().equals(
                domainCmdReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        return true;
    }

    /**
     * 校验delEntityRelVO方法
     * @param domainCmdReqDTO
     * @return
     */
    public boolean v4DelEntityRelVO(DomainCmdReqDTO domainCmdReqDTO) {
        ParamCheckUtil.checkNull(domainCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainEntity().getEntityIdCode(), "domain entity id code is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainCmdReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        ParamCheckUtil.checkTrue(domainCmdReqDTO.getDomainEntity().getDomainCode().equals(
                domainCmdReqDTO.getDomainValueObject().getDomainCode()), "domain code is not equal");
        return true;
    }
}
