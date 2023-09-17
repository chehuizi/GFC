CREATE TABLE `bmf_domain_app` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` int(11) NOT NULL COMMENT 'appID',
  `app_name` varchar(64) NOT NULL COMMENT 'app名称',
  `app_desc` varchar(64) NOT NULL COMMENT 'app描述',
  `domain_code` int(11) NOT NULL COMMENT '领域编号',
  `domain_alias` varchar(64) NOT NULL COMMENT '领域别名（英文）',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_app_domain` (`app_id`, `domain_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8