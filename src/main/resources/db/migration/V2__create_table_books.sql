create table if not exists books (
    id    int auto_increment PRIMARY KEY,
    name  varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id int not null,
    foreign key(customer_id) references customers(id)
);

-- INSERT INTO `books` (`id`,`name`,`price`,`status`,`customer_id`)
-- VALUES  (1,'Nascer do sol',13.00,'ATIVO',1),
--         (2,'Nascer da lua',18.00,'ATIVO',1),
--         (3,'Os ultimos serão os primeiros',21.00,'ATIVO',1),
--         (4,'O segundo é o primeiro dos perdedores',44.56,'ATIVO',1),
--         (5,'O segundo é o primeiro dos perdedores',44.56,'ATIVO',1),
--         (6,'Nem sempre foi assim',120.50,'ATIVO',1),
--         (7,'Todas as coisas',160.55,'ATIVO',1),
--         (8,'Aprendendo a aprender',118.20,'ATIVO',1),
--         (9,'Como os moinhos de vento',215.16,'ATIVO',1),
--         (10,'Brisa',77.70,'ATIVO',1),
--         (11,'No ritmo do amanhã',35.30,'ATIVO',1),
--         (12,'Duas faces da mesma moeda',33.30,'ATIVO',1),
--         (13,'Tristeza não se conta',80.78,'ATIVO',1),
--         (14,'Tristeza não se conta',80.78,'ATIVO',1),
--         (15,'Tregua nunca mais',99.99,'CANCELADO',1),
--         (16,'Tregua nunca mais',99.99,'CANCELADO',1),
--         (17,'Tregua nunca mais',99.99,'CANCELADO',1);
