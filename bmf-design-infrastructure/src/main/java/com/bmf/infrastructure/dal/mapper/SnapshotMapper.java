package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.SnapshotPO;

public interface SnapshotMapper {

    SnapshotPO selectOne(SnapshotPO snapshotPO);

    int insert(SnapshotPO snapshotPO);

    int update(SnapshotPO snapshotPO);

    int delete(SnapshotPO snapshotPO);
}
