package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.CodeSeqPO;

public interface CodeSeqMapper {

    CodeSeqPO selectByCodeKey(String codeKey);

    int insert(CodeSeqPO codeSeqPO);

    int update(CodeSeqPO codeSeqPO);
}
