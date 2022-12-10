package com.bmf.infrastructure.dal.po;

import lombok.Data;

import java.util.Date;

/**
 * code序列
 */
@Data
public class CodeSeqPO extends BasePO {

    /**
     * code码
     */
    private String codeKey;
    /**
     * code序列号
     */
    private Integer codeSeq;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModify;
}
