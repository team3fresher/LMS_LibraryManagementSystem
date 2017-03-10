create database Library;
use Library;
create table BOOK(
	isbn int primary key not null,
	title varchar(30) not null,
    author varchar(30) not null,
    publishing_year date not null,
    short_description varchar(50),
    brw_tckt_nber int not null,
    valid_status boolean,
    amount int not null,
    category_id int not null
);
create table BOOK_CATEGORY_DETAILS(
	category_id int not null primary key auto_increment,
    category_name varchar(20) not null
);
create table TICKET(
	user_id int not null,
    isbn int not null,
    borrowed_date date not null,
    expired_date date not null,
    ticket_id int not null primary key auto_increment,
    borrow_number int not null,
    limition_number int
);
create table STAFF_INFO(
	staff_id int not null primary key auto_increment,
    real_name varchar(30) not null,
    address varchar(30) not null,
    phone_number int(11) not null,
    email varchar(20),
    pword int(20) not null
);
create table STAFF_ROLE(
	staff_role_id int not null,
    role_id int not null,
    primary key (staff_role_id, role_id)
);
create table ROLE(
	role_id int not null auto_increment primary key,
    role_name varchar(20) not null
);
create table USER_INFO(
	user_id int not null auto_increment primary key,
    real_name varchar(30) not null,
    address varchar(30) not null,
    phone_number int(11) not null,
    email varchar(20) not null,
    pword int(20) not null
);
create table USER_ROLE(
	user_role_id int not null,
    role_id int not null,
    primary key (user_role_id, role_id)
);
create table RETURN_BOOK(
	user_id int not null,
    isbn int not null,
    borrowed_date date not null,
    expired_date date not null,
    returned_date date not null,
    fine int,
    return_book_id int not null primary key auto_increment
);
create table PAYMENT(
	user_id int not null,
    payment_amount int not null,
    pay_day date not null,
    fine int,
    payment_id int primary key not null auto_increment
);
alter table BOOK 
add constraint category_id_fk foreign key (category_id) references BOOK_CATEGORY_DETAILS(category_id);
alter table TICKET
add constraint user_id_fk_on_ticket foreign key (user_id) references USER_INFO(user_id);
alter table TICKET
add constraint isbn_fk_on_ticket foreign key (isbn) references BOOK(isbn);
alter table RETURN_BOOK
add constraint user_id_fk_on_return foreign key (user_id) references USER_INFO(user_id);
alter table RETURN_BOOK
add constraint isbn_fk_on_return foreign key (isbn) references BOOK(isbn);
alter table PAYMENT
add constraint user_id_fk_on_payment foreign key (user_id) references USER_INFO(user_id);

insert into role (role_name) value ("MEMBER_USER");
insert into role (role_name) value ("ADMIN");
insert into role (role_name) value ("GUEST");
