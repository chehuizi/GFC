package com.bmf.base;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.enums.RelationshipRoleEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DomainRelation extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域关系
     * @see com.bmf.base.enums.RelationshipEnum
     */
    private String domainRelation;
    /**
     * 领域A角色
     * @see com.bmf.base.enums.RelationshipRoleEnum
     */
    private String domainARole;
    /**
     * 领域A编码
     */
    private Integer domainACode;
    /**
     * 领域B角色
     * @see com.bmf.base.enums.RelationshipRoleEnum
     */
    private String domainBRole;
    /**
     * 领域B编码
     */
    private Integer domainBCode;

    /**
     * 获取扩展map
     * @return
     */
    public Map<String, Object> getExtMap() {
        Map<String, Object> extMap = new HashMap<>();
        extMap.put("domainARoleDesc", RelationshipRoleEnum.getDescByRole(domainARole));
        extMap.put("domainBRoleDesc", RelationshipRoleEnum.getDescByRole(domainBRole));
        extMap.put("domainRelationDesc", RelationshipEnum.getDescByType(domainRelation));
        return extMap;
    }
}
