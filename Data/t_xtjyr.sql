CREATE TABLE `dsc_cfg`.`t_xtjyr` (
  `ZRR` decimal(8,0) NOT NULL COMMENT '自然日',
  `JYR` decimal(8,0) NOT NULL COMMENT '交易日',
  `ND` decimal(4,0) NOT NULL COMMENT '年度',
  `JD` decimal(1,0) NOT NULL COMMENT '季度_年序',
  `YF_XH` decimal(6,0) NOT NULL COMMENT '月份序号',
  `XQ` decimal(8,0) NOT NULL COMMENT '星期_星期几,to_char(rq,''w'')-1',
  `NY` decimal(6,0) NOT NULL COMMENT '年月-年度+月份',
  `NZ` decimal(6,0) NOT NULL COMMENT '年周-年度+周号',
  `XQ_XH` decimal(6,0) NOT NULL COMMENT '星期序号',
  PRIMARY KEY (`ZRR`,`JYR`),
  KEY `IDX_T_XTJYR_JYR` (`JYR`) USING BTREE,
  KEY `IDX_T_XTJYR_ZRR` (`ZRR`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BSS_系统交易日'