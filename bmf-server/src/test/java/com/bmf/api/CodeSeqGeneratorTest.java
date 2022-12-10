package com.bmf.api;

import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.infrastructure.dal.po.CodeSeqPO;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeSeqGeneratorTest {

    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Test
    public void test_init_code_seq() {
        boolean result = codeSeqGenerator.initCodeSeq(CodeKeyEnum.CODE_KEY_BUSINESS.getKey(), 10000);
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @Test
    public void test_gen_seq() {
        Integer seqNo = codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_BUSINESS.getKey());
        System.out.println(seqNo);
        Assert.assertNotNull(seqNo);
    }

}

