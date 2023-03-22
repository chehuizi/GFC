CREATE TABLE `bmf_business_domain_entity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_code` int(11) NOT NULL COMMENT '领域编码',
  `entity_id_code` int(11) NOT NULL COMMENT '领域实体ID编码',
  `entity_id_alias` varchar(64) NOT NULL COMMENT '领域实体ID别名（英文）',
  `entity_id_name` varchar(64) NOT NULL COMMENT '领域实体ID名称（中文）',
  `entity_id_type` varchar(64) NOT NULL COMMENT '领域实体ID类型',
  `entity_desc` varchar(64) NOT NULL COMMENT '领域实体描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_domain_code_entity_id_code` (`domain_code`, `entity_id_code`),
  UNIQUE KEY `uk_domain_code_entity_id_alias` (`domain_code`, `entity_id_alias`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8