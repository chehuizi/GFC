package com.bmf.infrastructure.dal.impl;

import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.infrastructure.dal.DslExtRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDslExtMapper;
import com.bmf.infrastructure.dal.po.BusinessDslExtPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DslExtRepositoryImpl implements DslExtRepository {

    @Resource
    private BusinessDslExtMapper businessDslExtMapper;

    @Override
    public BusinessDslExt selectOne(BusinessDslExt req) {
        BusinessDslExtPO businessDslExtPO = POUtils.convert(req, BusinessDslExtPO.class);
        return POUtils.convert(businessDslExtMapper.selectOne(businessDslExtPO), BusinessDslExt.class);
    }

    @Override
    public boolean insert(BusinessDslExt req) {
        BusinessDslExtPO businessDslExtPO = POUtils.convert(req, BusinessDslExtPO.class);
        return businessDslExtMapper.insert(businessDslExtPO) == 1;
    }

    @Override
    public boolean update(BusinessDslExt req) {
        BusinessDslExtPO businessDslExtPO = POUtils.convert(req, BusinessDslExtPO.class);
        return businessDslExtMapper.update(businessDslExtPO) == 1;
    }

    @Override
    public boolean delete(BusinessDslExt req) {
        BusinessDslExtPO businessDslExtPO = POUtils.convert(req, BusinessDslExtPO.class);
        return businessDslExtMapper.delete(businessDslExtPO) == 1;
    }
}
