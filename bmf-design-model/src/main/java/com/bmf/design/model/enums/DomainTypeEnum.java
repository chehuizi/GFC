package com.bmf.design.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 业务域类型枚举
 * 目前只支持三种业务域类型
 */
@Getter
public enum DomainTypeEnum {

    CORE("core", "核心域"),
    GENERIC("generic", "通用域"),
    SUPPORTING("supporting", "支撑域"),
    ;

    /**
     * 域类型
     */
    private String type;
    /**
     * 域类型描述
     */
    private String desc;

    DomainTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 是否包含
     * @param type
     * @return
     */
    public static boolean contain(String type) {
        for (DomainTypeEnum item : DomainTypeEnum.values()) {
            if (item.getType().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据type获取枚举
     * @param type
     * @return
     */
    public static DomainTypeEnum getByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }

        for (DomainTypeEnum item : DomainTypeEnum.values()) {
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
        DomainTypeEnum domainTypeEnum = getByType(type);
        if (Objects.nonNull(domainTypeEnum)) {
            return domainTypeEnum.getDesc();
        }
        return StringUtils.EMPTY;
    }
}
