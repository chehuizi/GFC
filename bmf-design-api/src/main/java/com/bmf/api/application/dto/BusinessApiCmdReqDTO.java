package com.bmf.api.application.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.application.BusinessApi;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 业务API CMD请求对象
 */
@Data
public class BusinessApiCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -1577850349100928700L;

    /**
     * API列表
     */
    private List<BusinessApi> businessApiList;
}
