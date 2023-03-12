package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityRelVOPO;

import java.util.List;

public interface BusinessDomainEntityRelVOMapper {

    BusinessDomainEntityRelVOPO selectOne(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    List<BusinessDomainEntityRelVOPO> selectByEntityIdCode(Integer entityIdCode);

    int insert(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    int update(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    int delete(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

}
