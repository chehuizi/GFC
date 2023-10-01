package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.snapshot.Snapshot;
import com.bmf.design.infrastructure.dal.SnapshotRepository;
import com.bmf.design.infrastructure.dal.po.SnapshotPO;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.mapper.SnapshotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotRepositoryImpl implements SnapshotRepository {

    @Autowired
    private SnapshotMapper snapshotMapper;

    @Override
    public Snapshot selectOne(Snapshot req) {
        return null;
    }

    @Override
    public boolean insert(Snapshot req) {
        SnapshotPO snapshotPO = POUtils.convert(req, SnapshotPO.class);
        return snapshotMapper.insert(snapshotPO) == 1;
    }

    @Override
    public boolean update(Snapshot req) {
        return false;
    }

    @Override
    public boolean delete(Snapshot req) {
        return false;
    }
}
