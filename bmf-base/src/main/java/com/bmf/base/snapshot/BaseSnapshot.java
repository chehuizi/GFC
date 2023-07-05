package com.bmf.base.snapshot;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public abstract class BaseSnapshot extends BaseModel {

    /**
     * 快照
     * @return
     */
    public abstract String snapshot();
}
