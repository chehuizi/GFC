package com.bmf.infrastructure.dal.impl;

import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessRelDomainRepositoryImpl implements BusinessRelDomainRepository {

    @Resource
    private BusinessRelDomainMapper businessRelDomainMapper;

    @Override
    public BusinessRelDomainPO selectOne(BusinessRelDomainDO req) {
        return businessRelDomainMapper.selectOne(null);
    }

    @Override
    public List<BusinessRelDomainPO> selectList(BusinessRelDomainDO req) {
        BusinessRelDomainPO businessRelDomainPO = BusinessPOUtil.convert(req);
        return businessRelDomainMapper.selectList(businessRelDomainPO);
    }

    @Override
    public boolean insert(BusinessRelDomainDO req) {
        BusinessRelDomainPO businessRelDomainPO = new BusinessRelDomainPO();
        businessRelDomainPO.setBusinessCode(req.getBusinessCode());
        businessRelDomainPO.setDomainCode(req.getDomainCode());
        return businessRelDomainMapper.insert(businessRelDomainPO) == 1;
    }

    @Override
    public boolean update(BusinessRelDomainDO req) {
        return false;
    }

    @Override
    public boolean delete(BusinessRelDomainDO req) {
        BusinessRelDomainPO businessRelDomainPO = new BusinessRelDomainPO();
        businessRelDomainPO.setBusinessCode(req.getBusinessCode());
        businessRelDomainPO.setDomainCode(req.getDomainCode());
        return businessRelDomainMapper.delete(businessRelDomainPO) == 1;
    }
}
