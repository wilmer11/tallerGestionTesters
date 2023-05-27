create table IF NOT EXISTS `productos` (
    `id` bigint not null auto_increment,
    `nombre` varchar(255) not null,
    `precio` bigint not null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;