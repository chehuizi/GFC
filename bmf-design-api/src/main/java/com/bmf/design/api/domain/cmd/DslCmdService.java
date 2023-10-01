package com.bmf.design.api.domain.cmd;

import com.bmf.design.api.CmdService;
import com.bmf.design.api.Result;
import com.bmf.design.api.domain.dto.DslCmdReqDTO;

/**
 * DSL CMD接口
 */
public interface DslCmdService extends CmdService<DslCmdReqDTO> {

    /**
     * 添加DSL扩展属性
     * @param dslCmdReqDTO
     * @return
     */
    Result<Boolean> addDslExt(DslCmdReqDTO dslCmdReqDTO);

    /**
     * 删除DSL扩展属性
     * @param dslCmdReqDTO
     * @return
     */
    Result<Boolean> delDslExt(DslCmdReqDTO dslCmdReqDTO);
}
