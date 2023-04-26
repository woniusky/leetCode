drop table if exists monitor;
CREATE TABLE `monitor`
(
    `monitor_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `makers`     varchar(255) DEFAULT NULL,
    `owner`      varchar(255) DEFAULT NULL,
    `series`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`monitor_id`)
);

