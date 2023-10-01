package com.bmf.design.core.snapshot;

import com.bmf.design.base.snapshot.BaseSnapshot;

/**
 * 快照服务
 * @author chehuizi
 */
public interface SnapshotService {

    <T extends BaseSnapshot> boolean snapshot(T t);
}
