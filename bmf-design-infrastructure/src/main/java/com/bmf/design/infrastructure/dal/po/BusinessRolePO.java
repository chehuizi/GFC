package com.bmf.design.infrastructure.dal.po;

import com.bmf.design.model.enums.BusinessRoleTypeEnum;
import lombok.Data;

@Data
public class BusinessRolePO extends BasePO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色类型
     * @see BusinessRoleTypeEnum
     */
    private String roleType;
    /**
     * 角色名称（中文）
     */
    private String roleName;
    /**
     * 角色别名（英文）
     */
    private String roleAlias;
    /**
     * 角色描述
     */
    private String roleDesc;
}
