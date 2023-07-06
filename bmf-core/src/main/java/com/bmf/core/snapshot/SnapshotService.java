package com.bmf.core.snapshot;

import com.bmf.base.snapshot.BaseSnapshot;

/**
 * 快照服务
 * @author chehuizi
 */
public interface SnapshotService {

    <T extends BaseSnapshot> boolean snapshot(T t);
}
