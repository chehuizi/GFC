package com.bmf.core.snapshot.impl;

import com.bmf.base.snapshot.BaseSnapshot;
import com.bmf.core.snapshot.SnapshotService;
import org.springframework.stereotype.Service;

@Service
public class SnapshotServiceImpl implements SnapshotService {

    @Override
    public <T extends BaseSnapshot> boolean snapshot(T t) {
        t.getObjId();
        t.getObjType();
        t.getSnapshot();
        return false;
    }
}
