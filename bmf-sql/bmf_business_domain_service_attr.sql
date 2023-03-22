CREATE TABLE `bmf_business_domain_service_attr` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` int(11) NOT NULL COMMENT '服务编码',
  `attr_name` varchar(64) NOT NULL COMMENT '服务属性名称',
  `attr_type` varchar(64) NOT NULL COMMENT '服务属性类型',
  `attr_desc` varchar(64) NOT NULL COMMENT '服务属性描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_service_code_attr_name` (`service_code`, `attr_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8