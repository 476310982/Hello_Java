CREATE TABLE `dsc_cfg`.`t_xtjyr` (
  `ZRR` decimal(8,0) NOT NULL COMMENT '��Ȼ��',
  `JYR` decimal(8,0) NOT NULL COMMENT '������',
  `ND` decimal(4,0) NOT NULL COMMENT '���',
  `JD` decimal(1,0) NOT NULL COMMENT '����_����',
  `YF_XH` decimal(6,0) NOT NULL COMMENT '�·����',
  `XQ` decimal(8,0) NOT NULL COMMENT '����_���ڼ�,to_char(rq,''w'')-1',
  `NY` decimal(6,0) NOT NULL COMMENT '����-���+�·�',
  `NZ` decimal(6,0) NOT NULL COMMENT '����-���+�ܺ�',
  `XQ_XH` decimal(6,0) NOT NULL COMMENT '�������',
  PRIMARY KEY (`ZRR`,`JYR`),
  KEY `IDX_T_XTJYR_JYR` (`JYR`) USING BTREE,
  KEY `IDX_T_XTJYR_ZRR` (`ZRR`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BSS_ϵͳ������'