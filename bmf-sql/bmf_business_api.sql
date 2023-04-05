CREATE TABLE `bmf_business_api` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_name` varchar(64) NOT NULL COMMENT 'API名称',
  `api_path` varchar(512) NOT NULL COMMENT 'API路径',
  `api_desc` varchar(1024) COMMENT 'API描述',
  `service_code` int(11) NOT NULL COMMENT '领域服务编号',
  `service_alias` varchar(64) NOT NULL COMMENT '领域服务别名（英文）',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_business_code_api_path` (`service_code`, `api_path`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8