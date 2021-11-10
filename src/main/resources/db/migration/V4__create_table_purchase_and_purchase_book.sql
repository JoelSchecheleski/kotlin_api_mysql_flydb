create table if not exists purchases
(
    id    int auto_increment PRIMARY KEY,
    customer_id int not null,
    nfe varchar(255),
    price decimal(15,2) not null,
    created_at DATETIME not null,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

create table if not exists purchases_books
(
    purchase_id int not null,
    book_id int not null,
    FOREIGN KEY (purchase_id) REFERENCES purchases(id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    PRIMARY KEY (purchase_id, book_id)
);