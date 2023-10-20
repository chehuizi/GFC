CREATE TABLE `bmf_business_flow_node` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) NOT NULL DEFAULT 0 COMMENT '流程ID',
  `node_id` int(11) NOT NULL DEFAULT 0 COMMENT '节点ID',
  `node_name` varchar(64) NOT NULL DEFAULT '' COMMENT '节点名称（中文）',
  `node_alias` varchar(64) NOT NULL DEFAULT '' COMMENT '节点别名（英文）',
  `node_type` varchar(64) NOT NULL DEFAULT '' COMMENT '节点类型',
  `pre_nodes` varchar(1024) NOT NULL DEFAULT '' COMMENT '前置节点ID列表',
  `next_nodes` varchar(1024) NOT NULL DEFAULT '' COMMENT '后置节点ID列表',
  `condition` varchar(64) NOT NULL DEFAULT '' COMMENT '节点执行条件',
  `node_content` varchar(1024) NOT NULL DEFAULT '' COMMENT '节点内容',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1:删除 0:正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_flow_node` (`flow_id`, `node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8