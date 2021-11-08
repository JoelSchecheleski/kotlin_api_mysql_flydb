create table if not exists books (
    id    int auto_increment PRIMARY KEY,
    name  varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id int not null,
    foreign key(customer_id) references customers(id)
);