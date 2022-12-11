CREATE TABLE `bmf_business` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_prefix` varchar(32) NOT NULL COMMENT '业务前缀',
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `business_name` varchar(64) NOT NULL COMMENT '业务名称',
  `business_alias` varchar(64) NOT NULL COMMENT '业务别名',
  `business_desc` varchar(1024) NOT NULL COMMENT '业务描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_business_code` (`business_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8