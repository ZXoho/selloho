create table seller_info (
      seller_id varchar(32) not null,
      seller_name varchar(32) not null,
      password varchar(32) not null,
      openid varchar(64) not null,
      create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY(seller_id)
)COMMENT '卖家信息表';