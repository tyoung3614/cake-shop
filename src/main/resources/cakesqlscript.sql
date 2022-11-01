drop table if exists cake_type;
drop table if exists cake;
drop table if exists type;
drop table if exists client;

create table client (
client_id INT auto_increment not null, 
name VARCHAR(128) not null,
phone VARCHAR(128) not null,
email VARCHAR(128) not null,
primary key (client_id)
);

create table type (
type_id INT auto_increment not null,
type_text TEXT not null,
primary key (type_id)
);

create table cake (
cake_id INT auto_increment not null,
client_id INT not null, 
price DECIMAL(7,2) not null,
name VARCHAR(128) not null,
primary key (cake_id),
FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE cascade
);

create table cake_type (
cake_id INT not null,
type_id INT not null,
foreign key (cake_id) references cake (cake_id) on delete cascade,
foreign key (type_id) references type (type_id) on delete cascade,
unique key (cake_id, type_id)
);
