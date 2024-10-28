-- Código usado en la base de datos para el ejercicio--

create table tickets (
id int primary key auto_increment,
total_disponibles int not null
);

insert into tickets (total_disponibles) values (100);
