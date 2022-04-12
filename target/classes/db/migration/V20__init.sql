create table user (
  id bigint auto_increment not null ,
  full_name varchar(50) ,
  password varchar(50) ,
  username varchar(50) ,
  email varchar(50) ,
  constraint pk_user primary key (id) 
);

create table post (
  id bigint auto_increment not null ,
  body longtext not null ,
  date datetime ,
  title varchar(300) not null ,
  fk_user bigint ,
  constraint pk_post primary key (id)
);
alter table post
    add constraint FK_POST_ON_USER foreign key (fk_user) references user (id);