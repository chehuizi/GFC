CREATE TABLE `bmf_domain` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_code` int(11) NOT NULL COMMENT '领域编码',
  `domain_name` varchar(100) NOT NULL COMMENT '领域名称',
  `domain_alias` varchar(100) NOT NULL COMMENT '领域别名',
  `domain_type` varchar(100) NOT NULL COMMENT '领域类型',
  `domain_level` int(11) NOT NULL COMMENT '领域等级',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8