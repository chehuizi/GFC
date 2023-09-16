CREATE TABLE `bmf_domain_service` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_code` int(11) NOT NULL COMMENT '领域编码',
  `service_code` int(11) NOT NULL COMMENT '服务编码',
  `service_alias` varchar(64) NOT NULL COMMENT '服务别名（英文）',
  `service_name` varchar(64) NOT NULL COMMENT '服务名称（中文）',
  `service_desc` varchar(64) NOT NULL COMMENT '服务描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_domain_code_service_code` (`domain_code`, `service_code`),
  UNIQUE KEY `uk_domain_code_service_alias` (`domain_code`, `service_alias`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8