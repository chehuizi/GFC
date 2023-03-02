package com.bmf.base.tactics.service;

import com.bmf.base.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class DomainService extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 服务编码
     */
    private Integer serviceCode;
    /**
     * 服务别名（英文）
     */
    private String serviceAlias;
    /**
     * 服务名称（中文）
     */
    private String serviceName;
    /**
     * 服务描述
     */
    private String serviceDesc;

    /**
     * 服务属性列表
     */
    private List<DomainServiceAttr> serviceAttrList;
}
