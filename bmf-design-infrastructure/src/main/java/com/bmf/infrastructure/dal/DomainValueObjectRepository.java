package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.valueobject.DomainValueObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainValueObjectRepository extends BaseRepository<DomainValueObject> {

    /**
     * 根据值对象code查询
     * @param voCodeList
     * @return
     */
    List<DomainValueObject> selectByVoCode(@Param("voCodeList") List<Integer> voCodeList);
}