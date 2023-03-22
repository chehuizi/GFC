package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessDomainValueObjectMapper {

    BusinessDomainValueObjectPO selectOne(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    List<BusinessDomainValueObjectPO> selectByVoCode(@Param("voCodeList") List<Integer> voCodeList);

    int insert(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    int update(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    int delete(BusinessDomainValueObjectPO businessDomainValueObjectPO);

}
