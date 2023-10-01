package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.flow.BusinessRole;
import com.bmf.design.infrastructure.dal.mapper.BusinessRoleMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.BusinessRoleRepository;
import com.bmf.design.infrastructure.dal.po.BusinessRolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessRoleRepositoryImpl implements BusinessRoleRepository {

    @Autowired
    private BusinessRoleMapper businessRoleMapper;

    @Override
    public BusinessRole selectOne(BusinessRole req) {
        BusinessRolePO businessRolePO = POUtils.convert(req, BusinessRolePO.class);
        return POUtils.convert(businessRoleMapper.selectOne(businessRolePO), BusinessRole.class);
    }

    @Override
    public boolean insert(BusinessRole req) {
        BusinessRolePO businessRolePO = POUtils.convert(req, BusinessRolePO.class);
        return businessRoleMapper.insert(businessRolePO) == 1;
    }

    @Override
    public boolean update(BusinessRole req) {
        BusinessRolePO businessRolePO = POUtils.convert(req, BusinessRolePO.class);
        return businessRoleMapper.update(businessRolePO) == 1;
    }

    @Override
    public boolean delete(BusinessRole req) {
        BusinessRolePO businessRolePO = POUtils.convert(req, BusinessRolePO.class);
        return businessRoleMapper.delete(businessRolePO) == 1;
    }
}
