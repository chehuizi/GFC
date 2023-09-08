package com.bmf.core.domain.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.base.enums.CmdTypeEnum;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.DslBaseRepository;
import com.bmf.infrastructure.dal.DslExtRepository;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private DslBaseRepository dslBaseRepository;
    @Autowired
    private DslExtRepository dslExtRepository;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    public BusinessDomain queryDomain(BusinessDomain businessDomain) {
        return domainRepository.selectOne(businessDomain);
    }

    @Override
    public List<BusinessDomain> queryDomainByBusinessCode(Integer businessCode) {
        return domainRepository.selectByBusinessCode(businessCode);
    }

    @Override
    public List<BusinessDomain> queryDomainByCode(List<Integer> domainCodeList) {
        return domainRepository.selectByDomainCode(domainCodeList);
    }

    @Override
    public List<BusinessDomain> queryDomainByAlias(Integer businessCode, List<String> domainAliasList) {
        return domainRepository.selectByDomainAlias(businessCode, domainAliasList);
    }

    @Override
    public boolean createDomain(BusinessDomain businessDomain) {
        return domainRepository.insert(businessDomain);
    }

    @Override
    public boolean batchCreateDomain(List<BusinessDomain> businessDomainList) {
        return domainRepository.batchInsert(businessDomainList);
    }

    @Override
    public boolean updateDomain(BusinessDomain businessDomain) {
        return domainRepository.update(businessDomain);
    }

    @Override
    public boolean deleteDomain(BusinessDomain businessDomain) {
        return domainRepository.delete(businessDomain);
    }

    @Override
    public boolean addDsl(BusinessDslBase businessDslBase) {
        boolean baseResult = dslBaseRepository.insert(businessDslBase);
        if (baseResult && Objects.nonNull(businessDslBase.getDslExtList())
                && businessDslBase.getDslExtList().size() > 0) {
        }
        return baseResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean delDsl(BusinessDslBase businessDslBase) {
        boolean delBase = dslBaseRepository.delete(businessDslBase);
        if (delBase) {
            boolean delExt = dslExtRepository.delete(null);
        }
        return false;
    }

    @Override
    public boolean addDslExt(BusinessDslExt businessDslExt) {
        return dslExtRepository.insert(businessDslExt);
    }

    @Override
    public boolean delDslExt(BusinessDslExt businessDslExt) {
        return dslExtRepository.delete(businessDslExt);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<CmdTypeEnum, List<BusinessDomain>> handleStrategyDesign(Integer businessCode,
                                                                       List<BusinessDomain> domainList)
            throws BizException {
        List<BusinessDomain> existedDomains = domainRepository.selectByBusinessCode(businessCode);
        Map<String, BusinessDomain> existedDomainMapByAlias = Objects.nonNull(existedDomains) ?
                existedDomains.stream().collect(
                Collectors.toMap(e -> e.getDomainAlias(), e -> e)) : Collections.EMPTY_MAP;
        Map<Integer, BusinessDomain> existedDomainMapByCode = Objects.nonNull(existedDomains) ?
                existedDomains.stream().collect(
                Collectors.toMap(e -> e.getDomainCode(), e -> e)) : Collections.EMPTY_MAP;

        // 根据当前的领域和传入参数的比较，得出增删改的领域
        List<BusinessDomain> insertedDomains = new ArrayList<>();
        List<BusinessDomain> updatedDomains = new ArrayList<>();
        for (BusinessDomain domain : domainList) {
            if (Objects.isNull(existedDomainMapByAlias.get(domain.getDomainAlias()))
                && Objects.isNull(existedDomainMapByCode.get(domain.getDomainCode()))) {
                domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
                insertedDomains.add(domain);
            } else {
                BusinessCheckUtil.checkTrue(Objects.nonNull(domain.getDomainCode()) || StringUtils.isNotBlank(domain.getDomainAlias()),
                        BizCodeEnum.STRATEGY_DESIGN_DOMAIN_CODE_AND_ALIAS_ARE_BLANK);
                updatedDomains.add(domain);
                existedDomainMapByCode.remove(domain.getDomainCode());
            }
        }
        List<BusinessDomain> deletedDomains = new ArrayList<>(existedDomainMapByCode.values());

        boolean result;
        if (!insertedDomains.isEmpty()) {
            result = domainRepository.batchInsert(insertedDomains);
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_INSERTED_FAILED);
        }

        if (!updatedDomains.isEmpty()) {
            result = domainRepository.batchUpdate(updatedDomains);
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_UPDATED_FAILED);
        }

        if (!deletedDomains.isEmpty()) {
            result = domainRepository.batchDelete(deletedDomains);
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_DELETED_FAILED);
        }

        Map<CmdTypeEnum, List<BusinessDomain>> data = new HashMap<>();
        data.put(CmdTypeEnum.INSERT, insertedDomains);
        data.put(CmdTypeEnum.UPDATE, updatedDomains);
        data.put(CmdTypeEnum.DELETE, deletedDomains);
        return data;
    }
}
