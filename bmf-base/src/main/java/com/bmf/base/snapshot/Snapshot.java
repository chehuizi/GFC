package com.bmf.base.snapshot;

import com.bmf.base.BaseModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Snapshot extends BaseModel {

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
