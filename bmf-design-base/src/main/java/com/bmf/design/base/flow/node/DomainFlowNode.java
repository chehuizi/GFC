package com.bmf.design.base.flow.node;

import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.flow.BusinessFlowNode;
import lombok.Data;

/**
 * 领域节点
 */
@Data
public class DomainFlowNode extends BusinessFlowNode {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域名称
     */
    private String domainName;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;
    /**
     * 领域元素
     * @see com.bmf.design.base.enums.DomainElementEnum
     */
    private String domainElement;
    /**
     * 元素ID
     */
    private Integer elementId;
    /**
     * 元素名称
     */
    private String elementName;
    /**
     * 元素别名
     */
    private String elementAlias;

    public DomainFlowNode() {
        this.setNodeType(BusinessFlowNodeTypeEnum.DOMAIN.getType());
    }
}
