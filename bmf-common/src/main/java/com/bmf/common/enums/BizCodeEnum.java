package com.bmf.common.enums;

import lombok.Getter;

/**
 * 业务错误码
 */
@Getter
public enum BizCodeEnum {
    /******************** 系统错误码 start *********************/
    FUNCTION_NOT_SUPPORT(70001, "功能不支持"),
    PARAM_ERROR(80001, "参数错误"),
    VALIDATOR_ERROR(90001, "校验器异常"),
    VALIDATOR_METHOD_NOT_FOUND(90002, "校验器方法不存在"),
    /******************** 系统错误码 end   *********************/

    /******************** api层错误码 start ********************/
    BUSINESS_NOT_EXIST(100001, "业务不存在"),
    DOMAIN_NOT_EXIST(100002, "领域不存在"),
    BUSINESS_IS_EXISTED(100003, "业务已存在"),
    DOMAIN_IS_EXISTED(100004, "领域已存在"),
    DOMAIN_HAS_RELATION(100005, "领域有关系"),
    BUSINESS_REL_DOMAIN_NOT_EXIST(100006, "业务没有关联领域"),
    DOMAIN_ENTITY_IS_EXISTED(100007, "领域实体已存在"),
    DOMAIN_ENTITY_NOT_EXIST(100008, "领域实体不存在"),
    DOMAIN_VALUE_OBJECT_NOT_EXIST(100009, "领域值对象不存在"),
    ENTITY_REL_VO_IS_EXISTED(100010, "实体和值对象关系已存在"),
    DOMAIN_SERVICE_NOT_EXIST(100011, "领域服务不存在"),
    DOMAIN_EVENT_NOT_EXIST(100012, "领域事件不存在"),
    BUSINESS_FLOW_NOT_EXIST(100013, "业务流程不存在"),
    STRATEGY_DESIGN_DOMAIN_INSERTED_FAILED(100014, "战略设计领域新增失败"),
    STRATEGY_DESIGN_DOMAIN_UPDATED_FAILED(100015, "战略设计领域更新失败"),
    STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_HANDLE_FAILED(100016, "战略设计业务关联领域处理失败"),
    STRATEGY_DESIGN_DOMAIN_RELATION_HANDLE_FAILED(100017, "战略设计领域关系处理失败"),
    STRATEGY_DESIGN_DOMAIN_CODE_IS_NULL(100018, "战略设计领域编码是空"),
    STRATEGY_DESIGN_SNAPSHOT_FAILED(100019, "战略设计备份失败"),

    USER_NOT_EXIST(100200, "用户不存在"),
    /******************** api层错误码 end   ********************/
    ;

    private int code;
    private String desc;

    BizCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
