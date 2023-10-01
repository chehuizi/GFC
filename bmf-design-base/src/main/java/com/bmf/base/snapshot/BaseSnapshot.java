package com.bmf.base.snapshot;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public abstract class BaseSnapshot extends BaseModel {

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
     * @return
     */
    public abstract String getSnapshotContent();

}
