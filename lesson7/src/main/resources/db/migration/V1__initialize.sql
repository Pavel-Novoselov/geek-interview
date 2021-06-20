drop table if EXISTS students cascade;
create TABLE students(
    id bigserial,
    name VARCHAR (50),
    age INT,
    primary key(id)
);
insert into students (id, name, age)
values
(1, 'Pupkin', 25), (2, 'Ivanov', 20), (3, 'Petrov', 50);
