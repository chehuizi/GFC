package com.bmf.infrastructure.dal.impl;

import com.bmf.base.flow.BusinessRole;
import com.bmf.infrastructure.dal.BusinessRoleRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRoleMapper;
import com.bmf.infrastructure.dal.po.BusinessRolePO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessRoleRepositoryImpl implements BusinessRoleRepository {

    @Resource
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
