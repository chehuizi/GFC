package com.bmf.base;

import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务领域
 */
@Data
public class BusinessDomain extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;

    /**
     * 领域名称
     */
    private String domainName;

    /**
     * 领域别名
     */
    private String domainAlias;

    /**
     * 领域类型
     * @see com.bmf.base.enums.BusinessDomainTypeEnum
     */
    private String domainType;

    /**
     * 领域等级
     * @see com.bmf.base.enums.BusinessDomainLevelEnum
     */
    private int domainLevel;

    /**
     * 领域实体列表
     */
    private List<DomainEntity> domainEntityList;

    /**
     * 领域服务列表
     */
    private List<DomainService> domainServiceList;

    /**
     * 领域事件列表
     */
    private List<DomainEvent> domainEventList;

    public BusinessDomain(Integer domainCode, String domainName, String domainAlias, String domainType, int domainLevel) {
        this.domainCode = domainCode;
        this.domainName = domainName;
        this.domainAlias = domainAlias;
        this.domainType = domainType;
        this.domainLevel = domainLevel;
    }

    public BusinessDomain(int domainLevel, String domainType, String domainName, String domainAlias) {
        this.domainLevel = domainLevel;
        this.domainType = domainType;
        this.domainName = domainName;
        this.domainAlias = domainAlias;
    }

    public BusinessDomain() {
    }

    public BusinessDomain(Integer domainCode) {
        this.domainCode = domainCode;
    }

    @Override
    public String toString() {
        return "{" +
                "\"domainCode\": \"" + domainCode + "\"" +
                ", \"domainName\": \"" + domainName + "\"" +
                ", \"domainAlias\": \"" + domainAlias + "\"" +
                ", \"domainType\": \"" + domainType + "\"" +
                ", \"domainLevel\": " + domainLevel +
                "}";
    }

    /**
     * 获取扩展map
     * @return
     */
    public Map<String, Object> getExtMap() {
        Map<String, Object> extMap = new HashMap<>();
        extMap.put("domainTypeDesc", BusinessDomainTypeEnum.getDescByType(domainType));
        return extMap;
    }
}
