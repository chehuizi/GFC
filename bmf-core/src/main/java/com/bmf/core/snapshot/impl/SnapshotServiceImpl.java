package com.bmf.core.snapshot.impl;

import com.bmf.base.snapshot.BaseSnapshot;
import com.bmf.base.snapshot.Snapshot;
import com.bmf.core.snapshot.SnapshotService;
import com.bmf.infrastructure.dal.SnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotServiceImpl implements SnapshotService {

    @Autowired
    private SnapshotRepository snapshotRepository;

    @Override
    public <T extends BaseSnapshot> boolean snapshot(T t) {
        Snapshot snapshot = Snapshot.builder()
                .objId(t.getObjId())
                .objType(t.getObjType())
                .snapshotVersion(1)
                .snapshotContent(t.getSnapshotContent())
                .build();
        return snapshotRepository.insert(snapshot);
    }
}
