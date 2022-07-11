package com.bmf.core.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.common.validator.ParamValidator;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.design.BusinessDomainDesign4Strategy;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private BusinessRelDomainRepository businessRelDomainRepository;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        Business business = BusinessUtil.convert(req);
        boolean ret = businessRepository.insert(business);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> update(BusinessReqDTO req) {
        Business business = BusinessUtil.convert(req);
        boolean ret = businessRepository.update(business);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> delete(BusinessReqDTO req) {
        Business business = BusinessUtil.convert(req);
        boolean ret = businessRepository.delete(business);
        return Result.success(ret);
    }

    @Override
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        Business business = BusinessUtil.convert(req);
        BusinessPO businessPO = businessRepository.selectOne(business);
        BusinessRespDTO businessRespDTO = BusinessUtil.convert(businessPO);
        return Result.success(businessRespDTO);
    }

    @Override
    @ParamValidator
    public Result<Boolean> addDomain(BusinessReqDTO businessReqDTO) {
        BusinessRelDomainDO businessRelDomainDO = BusinessUtil.convertBusinessRelDomainDO(businessReqDTO);
        boolean result = businessRelDomainRepository.insert(businessRelDomainDO);
        return Result.success(result);
    }

    @Override
    public Result<Boolean> addDomainRelation(BusinessReqDTO businessReqDTO) {
        boolean result = businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessReqDTO.getBusiness(), businessReqDTO.getRelationship());
        return Result.success(result);
    }
}
