create table student_homework(
    id bigint(20) auto_increment primary key,
    homework_id bigint(20),
    student_id bigint(20),
    homework_title varchar(255),
    homework_content varchar(255),
    create_time timestamp ,
    update_time timestamp
    );

#user_type 0是学生 1是教师
create table user(
    user_id bigint(20) primary key,
    user_name varchar(20),
    user_password varchar(20),
    user_type int
    );


create table teacher_homework(
    homework_id bigint(20) auto_increment primary key,
    teacher_id bigint(20),
    homework_title varchar(255),
    homework_require varchar(255),
    create_time timestamp,
    final_time timestamp
    );