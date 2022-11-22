DROP table if exists ordenes;

create table if not exists ordenes(
  id int auto_increment primary key,
  cantidad int,
  descripcion varchar(255),
  referencia varchar (255));

delete from ordenes;

