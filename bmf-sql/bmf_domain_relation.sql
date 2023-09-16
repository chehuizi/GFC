CREATE TABLE `bmf_domain_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `domain_relation` varchar(64) NOT NULL COMMENT '领域关系',
  `domain_a_code` int(11) NOT NULL COMMENT '领域A编码',
  `domain_b_code` int(11) NOT NULL COMMENT '领域B编码',
  `domain_a_role` varchar(64) NOT NULL COMMENT '领域A角色',
  `domain_b_role` varchar(64) NOT NULL COMMENT '领域B角色',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_business_code_domain_code_1` (`business_code`, `domain_a_code`, `domain_b_code`),
  UNIQUE KEY `uk_business_code_domain_code_2` (`business_code`, `domain_b_code`, `domain_a_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8