package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.CodeSeqPO;

public interface CodeSeqMapper {

    CodeSeqPO selectByCodeKey(String codeKey);

    int insert(CodeSeqPO codeSeqPO);

    int update(CodeSeqPO codeSeqPO);
}
