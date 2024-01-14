CREATE TABLE IF NOT EXISTS public.CUSTOMERS
(
    id           integer generated by default as identity,
    name         varchar(200) not null,
    surname      varchar(200) not null,
    age          integer      not null,
    phone_number varchar(10)  not null,
    constraint CUSTOMERS_pk
        primary key (id)
);

CREATE TABLE IF NOT EXISTS public.ORDERS
(
    id           int generated by default as identity,
    date         date            not null,
    product_name varchar(200)    not null,
    amount       integer         not null,
    customer_id  integer         not null,
    constraint ORDERS_pk
        primary key (id),
    constraint ORDERS_CUSTOMERS_id_fk
        foreign key (customer_id) references public.CUSTOMERS (id)
);
