package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.dsl.BusinessDslExt;
import com.bmf.design.infrastructure.dal.mapper.BusinessDslExtMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DslExtRepository;
import com.bmf.design.infrastructure.dal.po.BusinessDslExtPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DslExtRepositoryImpl implements DslExtRepository {

    @Autowired
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
    public boolean batchInsert(List<BusinessDslExt> dslExtList) {
        List<BusinessDslExtPO> dslExtPOList = POUtils.convertModel2PO(dslExtList, BusinessDslExtPO.class);
        return businessDslExtMapper.batchInsert(dslExtPOList) == dslExtList.size();
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
