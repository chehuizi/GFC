package com.bmf.infrastructure.generator;

import com.bmf.infrastructure.dal.mapper.CodeSeqMapper;
import com.bmf.infrastructure.dal.po.CodeSeqPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * code序列号生成器
 */
@Service
public class CodeSeqGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CodeSeqGenerator.class);

    @Resource
    private CodeSeqMapper codeSeqMapper;

    /**
     * 根据codeKey获取code序列号
     * @param codeKey
     * @return
     */
    public Integer genSeqByCodeKey(String codeKey) {
        try {
            CodeSeqPO codeSeqPO = codeSeqMapper.selectByCodeKey(codeKey);
            int uptRet = codeSeqMapper.update(codeSeqPO);
            if (uptRet == 1) {
                return codeSeqPO.getCodeSeq() + 1;
            }
        } catch (Exception ex) {
            logger.error("generate code sequence error, codeKey={}", codeKey, ex);
        }
        return null;
    }

    /**
     * 初始化code序列号
     * @param codeKey
     * @param codeSeq
     * @return
     */
    public boolean initCodeSeq(String codeKey, Integer codeSeq) {
        try {
            CodeSeqPO codeSeqPO = new CodeSeqPO();
            codeSeqPO.setCodeKey(codeKey);
            codeSeqPO.setCodeSeq(codeSeq);
            return codeSeqMapper.insert(codeSeqPO) == 1;
        } catch (Exception ex) {
            logger.error("init code sequence error, codeKey={}", codeKey, ex);
        }
        return false;
    }
}
