package com.bmf.api.business;

import com.bmf.api.QryService;
import com.bmf.api.business.dto.BusinessQryReqDTO;
import com.bmf.api.business.dto.BusinessReqDTO;
import com.bmf.api.business.dto.BusinessRespDTO;

/**
 * 业务qry服务
 */
public interface BusinessQryService extends QryService<BusinessQryReqDTO, BusinessRespDTO> {

}
