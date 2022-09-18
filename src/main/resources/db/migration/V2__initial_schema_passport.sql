create table passport
(
    id            bigserial   not null primary key,
    passport_number integer not null,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    age           integer     not null
);
