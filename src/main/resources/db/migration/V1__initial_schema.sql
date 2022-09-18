create table human
(
    id    bigserial   not null primary key,
    name  varchar(50) not null,
    email varchar(50) not null,
    birth date        not null
);
