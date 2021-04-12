create table address (address_id integer not null auto_increment, name varchar(255), postal_code varchar(255), region_id integer, user_id integer, primary key (address_id)) engine=InnoDB
create table country (country_id integer not null auto_increment, name varchar(255), primary key (country_id)) engine=InnoDB
create table observed_bird (bird_id integer not null auto_increment, name varchar(255), post_id integer, region_id integer, primary key (bird_id)) engine=InnoDB
create table post (post_id integer not null auto_increment, description varchar(255), picture varchar(255), publish_date datetime(6), rate integer, title varchar(255), bird_id integer, user_id integer, primary key (post_id)) engine=InnoDB
create table region (region_id integer not null auto_increment, name varchar(255), country_id integer, primary key (region_id)) engine=InnoDB
create table user (user_id integer not null auto_increment, birth_date datetime(6), email_address varchar(255), first_name varchar(255), gender varchar(255), last_name varchar(255), phone varchar(255), address_id integer, primary key (user_id)) engine=InnoDB
alter table address add constraint FK4ljdc68rnke4txup1jlf1il4l foreign key (region_id) references region (region_id)
alter table address add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (user_id)
alter table observed_bird add constraint FKsh7b6pv5lkamiue55rnhs60in foreign key (post_id) references post (post_id)
alter table observed_bird add constraint FKs4bnqafwko990kqvos30db2fd foreign key (region_id) references region (region_id)
alter table post add constraint FKdpimxovg5x75s3d8r3i9fhdl5 foreign key (bird_id) references observed_bird (bird_id)
alter table post add constraint FK72mt33dhhs48hf9gcqrq4fxte foreign key (user_id) references user (user_id)
alter table region add constraint FK7vb2cqcnkr9391hfn72louxkq foreign key (country_id) references country (country_id)
alter table user add constraint FKddefmvbrws3hvl5t0hnnsv8ox foreign key (address_id) references address (address_id)
