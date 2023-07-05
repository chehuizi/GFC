CREATE TABLE `bmf_snapshot` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `obj_id` varchar(64) NOT NULL COMMENT '快照对象ID',
  `obj_type` varchar(64) NOT NULL COMMENT '快照对象类型',
  `snapshot_version` int(11) NOT NULL COMMENT '快照版本',
  `snapshot_content` varchar(8192) NOT NULL COMMENT '快照内容',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_obj_version` (`obj_id`, `obj_type`, `snapshot_version`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8