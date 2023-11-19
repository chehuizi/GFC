package com.bmf.design.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 业务域关系枚举
 */
@Getter
public enum RelationshipEnum {

    PS("partnership", "合作伙伴"),
    SK("shared-kernel", "共享内核"),
    UD("upstream-downstream", "上下游"),
    CS("customer-supplier", "客户/供应商"),
    ;

    /**
     * 关系类型
     */
    private String type;
    /**
     * 关系描述
     */
    private String desc;

    RelationshipEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 根据type获取枚举
     * @param type
     * @return
     */
    public static RelationshipEnum getByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }

        for (RelationshipEnum item : RelationshipEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }

        return null;
    }

    /**
     * 根据type获取描述
     * @param type
     * @return
     */
    public static String getDescByType(String type) {
        RelationshipEnum relationshipEnum = getByType(type);
        if (Objects.nonNull(relationshipEnum)) {
            return relationshipEnum.getDesc();
        }
        return StringUtils.EMPTY;
    }
}
