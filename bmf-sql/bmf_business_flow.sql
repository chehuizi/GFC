CREATE TABLE `bmf_business_flow` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `flow_id` int(11) NOT NULL COMMENT '流程ID',
  `flow_name` varchar(64) NOT NULL COMMENT '流程名称（中文）',
  `flow_alias` varchar(64) NOT NULL COMMENT '流程别名（英文）',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_business_code_flow_id` (`business_code`, `flow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8