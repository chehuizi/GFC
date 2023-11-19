package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.tactics.valueobject.DomainValueObject;
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