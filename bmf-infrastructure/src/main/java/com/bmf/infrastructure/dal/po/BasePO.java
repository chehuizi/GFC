package com.bmf.infrastructure.dal.po;

import lombok.Data;

import java.util.Date;

@Data
public class BasePO {

    /**
     * 主键ID
     */
    private int id;
    /**
     * 是否删除（1:删除 0:正常）
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
