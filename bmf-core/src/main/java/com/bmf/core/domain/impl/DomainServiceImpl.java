package com.bmf.core.domain.impl;

import com.bmf.base.Domain;
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
    public Domain queryDomain(Domain domain) {
        return domainRepository.selectOne(domain);
    }

    @Override
    public List<Domain> queryDomainByBusinessCode(Integer businessCode) {
        return domainRepository.selectByBusinessCode(businessCode);
    }

    @Override
    public List<Domain> queryDomainByCode(List<Integer> domainCodeList) {
        return domainRepository.selectByDomainCode(domainCodeList);
    }

    @Override
    public boolean createDomain(Domain domain) {
        return domainRepository.insert(domain);
    }

    @Override
    public boolean batchCreateDomain(List<Domain> domainList) {
        return domainRepository.batchInsert(domainList);
    }

    @Override
    public boolean updateDomain(Domain domain) {
        return domainRepository.update(domain);
    }

    @Override
    public boolean deleteDomain(Domain domain) {
        return domainRepository.delete(domain);
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
    public Map<CmdTypeEnum, List<Domain>> handleStrategyDesign(Integer businessCode,
                                                               List<Domain> domainList)
            throws BizException {
        List<Domain> existedDomains = domainRepository.selectByBusinessCode(businessCode);
        Map<Integer, Domain> existedDomainMapByCode = Objects.nonNull(existedDomains) ?
                existedDomains.stream().collect(
                Collectors.toMap(e -> e.getDomainCode(), e -> e)) : Collections.EMPTY_MAP;

        // 根据当前的领域和传入参数的比较，得出增删改的领域
        List<Domain> insertedDomains = new ArrayList<>();
        List<Domain> updatedDomains = new ArrayList<>();
        for (Domain domain : domainList) {
            if (Objects.isNull(existedDomainMapByCode.get(domain.getDomainCode()))) {
                domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
                insertedDomains.add(domain);
            } else {
                updatedDomains.add(domain);
                existedDomainMapByCode.remove(domain.getDomainCode());
            }
        }
        List<Domain> deletedDomains = new ArrayList<>(existedDomainMapByCode.values());

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

        Map<CmdTypeEnum, List<Domain>> data = new HashMap<>();
        data.put(CmdTypeEnum.INSERT, insertedDomains);
        data.put(CmdTypeEnum.UPDATE, updatedDomains);
        data.put(CmdTypeEnum.DELETE, deletedDomains);
        return data;
    }
}
