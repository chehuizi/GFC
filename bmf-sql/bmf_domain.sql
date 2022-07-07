CREATE TABLE `bmf_domain` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_code` int(11) NOT NULL COMMENT '领域编码',
  `domain_name` varchar(100) NOT NULL COMMENT '领域名称',
  `domain_type` varchar(100) NOT NULL COMMENT '领域类型',
  `domain_level` int(11) NOT NULL COMMENT '领域等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8