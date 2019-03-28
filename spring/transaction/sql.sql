create DATABASE tx_demo DEFAULT CHARACTER SET utf8;
use tx_demo;

CREATE TABLE `tx_user` (
  `username` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



