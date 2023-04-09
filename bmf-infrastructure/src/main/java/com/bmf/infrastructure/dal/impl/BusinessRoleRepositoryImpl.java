package com.bmf.infrastructure.dal.impl;

import com.bmf.base.flow.BusinessRole;
import com.bmf.infrastructure.dal.BusinessRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessRoleRepositoryImpl implements BusinessRoleRepository {

    @Override
    public BusinessRole selectOne(BusinessRole req) {
        return null;
    }

    @Override
    public boolean insert(BusinessRole req) {
        return false;
    }

    @Override
    public boolean update(BusinessRole req) {
        return false;
    }

    @Override
    public boolean delete(BusinessRole req) {
        return false;
    }
}
