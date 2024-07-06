create table user_sys_draw(
    user_sys_draw_id int not null auto_increment primary key,
    created_at datetime not null DEFAULT CURRENT_TIMESTAMP,
    user_name varchar(20) unique not null
    );


create table family (
    family_id int not null auto_increment primary key,
    user_sys_draw_id int,
    created_at datetime not null DEFAULT CURRENT_TIMESTAMP,
    family_name varchar(50) not null,
    constraint fk_user_sys_draw_family foreign key (user_sys_draw_id) references user_sys_draw (user_sys_draw_id)

);

create table person(
    person_id int not null auto_increment primary key,
    family_id int not null,
    created_at datetime not null DEFAULT CURRENT_TIMESTAMP,
    first_name varchar(20) not null,
    curp varchar(20) unique not null,
    constraint fk_family_person foreign key (family_id) references family (family_id)
);

create table draw_selection(
 draw_selection_id int not null auto_increment primary key,
 person_id_receive int not null ,
 person_id_give int not null ,
 year_draw int,
    constraint fk_person_give_draw_selection foreign key (person_id_give) references person (person_id),
    constraint fk_person_receive_draw_selection foreign key (person_id_receive) references person (person_id)

);


INSERT INTO user_sys_draw VALUES (1,'2024-07-04 21:36:51','NICKNAME1');

INSERT INTO family VALUES (1,1,'2024-07-04 21:40:39','Lopez'),
(2,1,'2024-07-04 21:40:39','Gonzalez'),
(3,1,'2024-07-04 21:40:39','Romo');

INSERT INTO person VALUES (1,1,'2024-07-04 21:49:06','Carlos','jsosodsd'),
(2,1,'2024-07-04 21:49:06','Juan','ksjsidjj'),
(3,1,'2024-07-04 21:49:06','Ana','owkssisj'),
(4,2,'2024-07-04 21:49:06','Pedro','osjwnsisj'),
(5,2,'2024-07-04 21:49:06','Karla','mqksoij'),
(6,3,'2024-07-04 21:49:06','Hugo','ksjsisnb'),
(7,3,'2024-07-04 21:49:06','Martha','ssjqjwj');

INSERT INTO draw_selection VALUES (1,1,4,2021),(2,1,4,2022),(3,1,4,2023),(4,2,5,2022),(5,2,7,2023),(6,7,2,2023);


-- SEGUNDA ETAPA, DONDE NO SE PUEDEN EMPAREJAR TODOS


INSERT INTO user_sys_draw VALUES (2,'2024-07-04 21:36:51','NICKNAME2');
INSERT INTO family VALUES 
(4,2,'2024-07-04 21:40:39','Correa'),
(5,2,'2024-07-04 21:40:39','Andrade');

INSERT INTO person VALUES (8,4,'2024-07-04 21:49:06','Andrea','ksjqowjsb'),
(9,4,'2024-07-04 21:49:06','Ana','ksk1j232'),
(10,5,'2024-07-04 21:49:06','Camila','osos18sn2');

-- UNO YA DIO UN REGALO A OTRO


INSERT INTO user_sys_draw VALUES (3,'2024-07-04 21:36:51','NICKNAME3');
INSERT INTO family VALUES 
(6,3,'2024-07-04 21:40:39','Per'),
(7,3,'2024-07-04 21:40:39','Coyoc');

INSERT INTO person VALUES 
(11,6,'2024-07-04 21:49:06','Andrea','92jsu'),
(12,6,'2024-07-04 21:49:06','Ana','0sn198sg'),
(13,7,'2024-07-04 21:49:06','Camila','o2i2j'),
(14,7,'2024-07-04 21:49:06','Norma','92j2n2is');
INSERT INTO draw_selection VALUES (7,12,13,2021),(8,12,14,2022);


