-- creacion de la base de datos
create database idwebapp;

use idwebapp;

create table usuario(
	id int primary key auto_increment,
    nombre varchar(500) not null,
    usuario varchar(100) unique not null,
    clave varchar(500) not null,
    habilitado boolean not null default true
);

create table rol(
	id int primary key auto_increment,
    rol varchar(100) not null unique,
    descripcion varchar(500)
);

create table usuario_roles(
	usuario_id int not null,
    rol_id int not null,
    foreign key(usuario_id) references usuario(id),
    foreign key(rol_id) references rol(id)
);

-- registro de roles
insert into rol(rol, descripcion) values 
('ROLE_MANAGEMENT', 'Autoriza las compras.'),
('ROLE_SALES', 'Gestión de clientes, facturas y presupuestos.'),
('ROLE_HUMANR', 'Gestión de nóminas y de trabajadores.'),
('ROLE_PURCHASES', 'Gestión de compras y de proveedores.'),
('ROLE_AUDITOR', 'Auditor');

-- registro de usuarios
insert into usuario (nombre, usuario, clave, habilitado) values 
('Ethan Edwards', 'ethan', '$2a$10$YUG.CsYNiPfZYEa9ULMhzeVhiWSFTbsIKr1YfVJVwcHKj9P5lj0fy', true),
('Martin Pawley', 'martin', '$2a$10$YUG.CsYNiPfZYEa9ULMhzeVhiWSFTbsIKr1YfVJVwcHKj9P5lj0fy', true),
('Laurie Jorgensen', 'laurie', '$2a$10$YUG.CsYNiPfZYEa9ULMhzeVhiWSFTbsIKr1YfVJVwcHKj9P5lj0fy', true),
('Samuel Johnson', 'samuel', '$2a$10$YUG.CsYNiPfZYEa9ULMhzeVhiWSFTbsIKr1YfVJVwcHKj9P5lj0fy', true),
('Debbie Edwards', 'debbie', '$2a$10$YUG.CsYNiPfZYEa9ULMhzeVhiWSFTbsIKr1YfVJVwcHKj9P5lj0fy', true);

-- asignacion de roles
insert into usuario_roles(usuario_id, rol_id) values
(1,1), (1,2), (1,3), (1,4),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

