create table if not exists customers
(
    id    int auto_increment PRIMARY KEY,
    name  varchar(255) not null,
    email varchar(255) not null unique
);

insert into customers(name, email) values
    ('Joel Schecheleski', 'joel.jsp@gmail.com'),
    ('Kátia Michele Jurk Avalos Schecheleski', 'kmjavalos@gmail.com'),
    ('Miguel Schecheleski', 'miguel@gmail.com'),
    ('Raquel Schecheleski', 'Raquel@gmail.com');