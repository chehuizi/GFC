package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityRelVOPO;

public interface BusinessDomainEntityRelVOMapper {

    BusinessDomainEntityRelVOPO selectOne(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    int insert(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    int update(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

    int delete(BusinessDomainEntityRelVOPO businessDomainEntityRelVOPO);

}
