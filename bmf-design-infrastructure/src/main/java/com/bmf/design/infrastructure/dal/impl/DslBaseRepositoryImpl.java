package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.dsl.BusinessDslBase;
import com.bmf.design.infrastructure.dal.mapper.BusinessDslBaseMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DslBaseRepository;
import com.bmf.design.infrastructure.dal.po.BusinessDslBasePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DslBaseRepositoryImpl implements DslBaseRepository {

    @Autowired
    private BusinessDslBaseMapper businessDslBaseMapper;

    @Override
    public BusinessDslBase selectOne(BusinessDslBase req) {
        BusinessDslBasePO businessDslBasePO = POUtils.convert(req, BusinessDslBasePO.class);
        return POUtils.convert(businessDslBaseMapper.selectOne(businessDslBasePO), BusinessDslBase.class);
    }

    @Override
    public boolean insert(BusinessDslBase req) {
        BusinessDslBasePO businessDslBasePO = POUtils.convert(req, BusinessDslBasePO.class);
        return businessDslBaseMapper.insert(businessDslBasePO) == 1;
    }

    @Override
    public boolean update(BusinessDslBase req) {
        BusinessDslBasePO businessDslBasePO = POUtils.convert(req, BusinessDslBasePO.class);
        return businessDslBaseMapper.update(businessDslBasePO) == 1;
    }

    @Override
    public boolean delete(BusinessDslBase req) {
        BusinessDslBasePO businessDslBasePO = POUtils.convert(req, BusinessDslBasePO.class);
        return businessDslBaseMapper.delete(businessDslBasePO) == 1;
    }
}
