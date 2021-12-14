create database if not exists gerenciador_favoritos;

use gerenciador_favoritos;

create table favoritos(
    id int not null auto_increment primary key,
    nome varchar(255) not null unique,
    url varchar(1023) not null,
    assunto varchar(255) not null
);

drop database gerenciador_favoritos;
