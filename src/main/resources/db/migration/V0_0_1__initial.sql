start transaction;

create table sex
(
    id_sex serial       not null
        constraint sex_pk
            primary key,
    title  varchar(255) not null
);

create table position
(
    id_position serial       not null
        constraint position_pk
            primary key,
    title       varchar(255) not null
);


create table employee
(
    id_employee serial       not null
        constraint employee_pk
            primary key,
    first_name  varchar(255) not null,
    middle_name varchar(255) not null,
    last_name   varchar(255) not null,
    id_position serial       not null
        constraint employee_position_id_position_fk
            references position,
    id_sex      int          not null
        constraint employee_sex_id_sex_fk
            references sex,
    password    varchar(255) not null,
    birthday    date         not null,
    email       varchar(255) not null
);

create unique index employee_email_uindex
    on employee (email);

commit;

