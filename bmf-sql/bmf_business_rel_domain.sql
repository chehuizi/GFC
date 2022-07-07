CREATE TABLE `bmf_business_rel_domain` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `domain_code` bigint(20) unsigned NOT NULL COMMENT '领域编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8