package com.bmf.base.flow;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务角色
 */
@Data
public class BusinessRole extends BaseModel {

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
     * @see com.bmf.base.enums.BusinessRoleTypeEnum
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
