package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class SnapshotPO extends BasePO {

    /**
     * 快照对象ID
     */
    private String objId;
    /**
     * 快照对象类型
     */
    private String objType;
    /**
     * 快照内容
     */
    private String snapshotContent;
}
