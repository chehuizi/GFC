package com.bmf.design.core.snapshot.impl;

import com.bmf.design.base.snapshot.BaseSnapshot;
import com.bmf.design.base.snapshot.Snapshot;
import com.bmf.design.core.snapshot.SnapshotService;
import com.bmf.design.infrastructure.dal.SnapshotRepository;
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
                .snapshotContent(t.getSnapshotContent())
                .build();
        return snapshotRepository.insert(snapshot);
    }
}
