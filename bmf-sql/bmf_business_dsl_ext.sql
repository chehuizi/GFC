CREATE TABLE `bmf_business_dsl_ext` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dsl_code` int(11) NOT NULL COMMENT 'DSL编码',
  `dsl_ext_type` varchar(64) NOT NULL COMMENT 'DSL扩展字段类型',
  `dsl_ext_key` varchar(64) NOT NULL COMMENT 'DSL扩展字段key',
  `dsl_ext_val` varchar(64) NOT NULL COMMENT 'DSL扩展字段value',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8