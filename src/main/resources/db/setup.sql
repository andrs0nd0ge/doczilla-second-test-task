create schema if not exists s;

create table if not exists s.students
(
    id            bigserial
        constraint students_pk
            primary key,
    first_name    varchar(70),
    last_name     varchar(70),
    patronymic    varchar(70),
    date_of_birth date,
    study_group   varchar(20)
);

alter table s.students
    owner to postgres;

create unique index if not exists students_id_uindex
    on s.students (id);