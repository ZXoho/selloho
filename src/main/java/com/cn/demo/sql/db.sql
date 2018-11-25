/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.42-log : Database - selloho
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`selloho` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `selloho`;

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL,
  `product_price` decimal(8,2) NOT NULL,
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

/*Data for the table `order_detail` */

insert  into `order_detail`(`detail_id`,`order_id`,`product_id`,`product_name`,`product_price`,`product_quantity`,`product_icon`,`create_time`,`update_time`) values ('d54gb5xgb6','4df4sx6f454fwsf','41','枣药丸','2.60',1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542355243854&di=076bc33e0b4675e7ce90d99863e5f0a0&imgtype=0&src=http%3A%2F%2Fimgup01.sj88.com%2F2018-06%2F12%2F10%2F15287694476579_2.jpg','2018-11-16 13:23:37','2018-11-16 13:24:02'),('fc65gbhf65+','46fv32hf31','20','皮皮虾','25.00',1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542355380195&di=ea4961e42aa03eac26507383c81282a8&imgtype=0&src=http%3A%2F%2Ftp.yiaedu.com%2Fshowimg.php%3Furl%3Dhttp%3A%2F%2Fuploads.xuexila.com%2Fallimg%2F1703%2F861-1F330160T9.jpg','2018-11-16 13:21:43','2018-11-16 13:22:11');

/*Table structure for table `order_master` */

DROP TABLE IF EXISTS `order_master`;

CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL,
  `buyer_phone` varchar(32) NOT NULL,
  `buyer_address` varchar(128) NOT NULL,
  `buyer_open_id` varchar(64) NOT NULL COMMENT '买家微信id',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单金额',
  `order_status` int(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认0为新下单',
  `pay_status` int(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0为未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_open_id` (`buyer_open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

/*Data for the table `order_master` */

insert  into `order_master`(`order_id`,`buyer_name`,`buyer_phone`,`buyer_address`,`buyer_open_id`,`order_amount`,`order_status`,`pay_status`,`create_time`,`update_time`) values ('46fv32hf31','186学姐','18280003725','电子科技大学清水河校区','deg4v56ed465','1.00',1,0,'2018-11-16 13:19:12','2018-11-16 13:19:12'),('4df4sx6f454fwsf','蔡斌','15463776863','西华大学','dsg4ef5ef56','2.00',0,0,'2018-11-16 13:19:46','2018-11-16 13:19:46');

/*Table structure for table `product_category` */

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COMMENT='类目表';

/*Data for the table `product_category` */

insert  into `product_category`(`category_id`,`category_name`,`category_type`,`create_time`,`update_time`) values (4,'调料',5,'2018-11-16 15:27:11','2018-11-16 17:12:12'),(20,'海鲜',3,'2018-11-16 13:17:24','2018-11-16 13:18:02'),(32,'神兽',1,'2018-11-16 13:16:42','2018-11-16 13:17:55'),(41,'保健',2,'2018-11-16 13:16:55','2018-11-16 13:17:58');

/*Table structure for table `product_info` */

DROP TABLE IF EXISTS `product_info`;

CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品信息',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态，0为上架，1为下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

/*Data for the table `product_info` */

insert  into `product_info`(`product_id`,`product_name`,`product_price`,`product_stock`,`product_description`,`product_icon`,`product_status`,`category_type`,`create_time`,`update_time`) values ('1541556','红烧牛肉','30.00',100,'红烧牛肉很好吃','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542453122998&di=3e18b8e83dd3ac8535632652b1f7dced&imgtype=0&src=http%3A%2F%2Fwww.laonanren.cc%2Fuploads%2Fallimg%2F160509%2F3-16050916001TK.jpg',0,32,'2018-11-16 13:11:46','2018-11-17 16:24:48'),('1542359373040714933','鱼香茄子','6.00',1000,'本店招牌','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542453189723&di=38b509a21b9acb9c2ad0535b0a7718cd&imgtype=0&src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2016%2F05%2F08%2FFtrQnAmO9e4eXp0cCNSL_8px51HA.jpg%3FimageView2%2F2%2Fw%2F580%2Fh%2F580%2Fq%2F75%2Fformat%2Fjpg',0,4,'2018-11-16 17:09:33','2018-11-17 16:26:04'),('6543132','松露鹅肝','2000.00',200,'低调奢华','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542453238811&di=edc03f29243ca9f47aae9682e7e02843&imgtype=0&src=http%3A%2F%2Fpic3.58cdn.com.cn%2Fzhuanzh%2Fn_v2c29bd50c81e54ae0a524d149fa624351_338_282.jpg',0,41,'2018-11-16 13:12:58','2018-11-17 16:26:27'),('9846363','皮皮虾','25.00',320,'皮皮虾我们走','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542453283436&di=024943e800bbbc9e517911d51b1386b4&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161104%2Fe51d941ad0bd4bf8acb7cd243e31ce7c_th.jpeg',0,3,'2018-11-16 13:15:15','2018-11-17 16:27:13');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL,
  `role_name` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`) values ('2165165','用户'),('6541322','商家'),('8956623','管理员');

/*Table structure for table `seller_info` */

DROP TABLE IF EXISTS `seller_info`;

CREATE TABLE `seller_info` (
  `seller_id` varchar(32) NOT NULL,
  `seller_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `openid` varchar(64) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `role_name` varchar(32) NOT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='卖家信息表';

/*Data for the table `seller_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
