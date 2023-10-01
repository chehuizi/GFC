package com.bmf.design.base.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 业务域关系角色枚举
 */
@Getter
public enum RelationshipRoleEnum {

    PL("PL", "发布语言"),
    OHS("OHS", "开放主机服务"),
    ACL("ACL", "防腐层"),
    CF("CF", "遵从者"),

    SUPPLIER("SUPPLIER", "供应商"),
    CUSTOMER("CUSTOMER", "客户"),

    PARTNER("partner", "合作伙伴"),
    ;

    /**
     * 关系角色
     */
    private String role;
    /**
     * 关系角色描述
     */
    private String desc;

    RelationshipRoleEnum(String role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    /**
     * 根据role获取枚举
     * @param role
     * @return
     */
    public static RelationshipRoleEnum getByRole(String role) {
        if (StringUtils.isBlank(role)) {
            return null;
        }

        for (RelationshipRoleEnum item : RelationshipRoleEnum.values()) {
            if (item.getRole().equals(role)) {
                return item;
            }
        }

        return null;
    }

    /**
     * 根据role获取描述
     * @param role
     * @return
     */
    public static String getDescByRole(String role) {
        RelationshipRoleEnum roleEnum = getByRole(role);
        if (Objects.nonNull(roleEnum)) {
            return roleEnum.getDesc();
        }
        return StringUtils.EMPTY;
    }
}
