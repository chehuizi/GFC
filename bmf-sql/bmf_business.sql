CREATE TABLE `bmf_business` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_code` int(11) NOT NULL COMMENT '业务编码',
  `business_name` varchar(64) NOT NULL COMMENT '业务名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8