CREATE TABLE product_info(
product_id VARCHAR(32) NOT NULL,
product_name VARCHAR(64) NOT NULL COMMENT '商品信息',
product_price DECIMAL(8,2)NOT NULL COMMENT '单价',
product_stock INT NOT NULL COMMENT'库存',
product_description VARCHAR(64) COMMENT '描述',
product_icon VARCHAR(512) COMMENT '小图',
product_status tinyint(3) default 0 comment '商品状态，0为上架，1为下架',
category_type INT NOT NULL COMMENT '类目编号',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'创建时间',
update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT'修改时间',


PRIMARY KEY(product_id)

)COMMENT '商品表';

create table product_category (
      category_id int not null auto_increment,
      category_name varchar(64) not null comment '类目名字',
      category_type int not null comment '类目编号',
      create_time timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
      update_time timestamp not null default CURRENT_TIMESTAMP on UPDATE  CURRENT_TIMESTAMP comment '修改时间',
      PRIMARY key (category_id),
      unique key uqe_category_type (category_type)
)comment '类目表';

create table order_master (
      order_id varchar(32) not null,
      buyer_name varchar(32) not null,
      buyer_phone varchar(32) not null ,
      buyer_address varchar (128) not null ,
      buyer_openid varchar(64) not null comment '买家微信id',
      order_amount decimal(8,2) not null comment '订单金额',
      order_status int(3) not null default 0 comment '订单状态，默认0为新下单',
      pay_status int(3) not null default 0 comment '支付状态，默认0为未支付',
      create_time timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
      update_time timestamp not null default CURRENT_TIMESTAMP on UPDATE  CURRENT_TIMESTAMP comment '修改时间',
      primary key (order_id),
      KEY idx_buyer_openid (buyer_openid)
)comment '订单表';





create table order_detail (
      detail_id varchar(32) not null,
      order_id varchar(32) not null,
      product_id varchar(32) not null,
      product_name varchar(64) not null,
      product_price decimal(8,2) not null,
      product_quantity int not null comment '商品数量',
      product_icon varchar(512) comment '商品图片',
      create_time timestamp not null default CURRENT_TIMESTAMP  comment '创建时间',
      update_time timestamp not null default CURRENT_TIMESTAMP on UPDATE  CURRENT_TIMESTAMP comment '修改时间',
      primary key (detail_id),
      KEY idx_order_id (order_id)
 )comment '订单详情表';