create table product(
    id bigint not null auto_increment,
    name varchar(100) not null,
    price decimal(10,2) not null DEFAULT '0.00',
    quantity int(10) unsigned not null DEFAULT '0',
    primary key(`id`)
);