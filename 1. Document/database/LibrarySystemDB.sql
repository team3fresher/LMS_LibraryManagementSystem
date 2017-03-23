create database if not exists Library;
use Library;
create table BOOK(
	isbn bigint(13) primary key not null,
	title varchar(100) not null,
    publisher_id int not null,
    publishing_year year not null,
    category_id int not null,
    short_description varchar(1500),
    brw_tckt_nber int not null,
    valid_status boolean,
    amount int not null,
    importance int(1) not null
);
create table AUTHOR_DETAILS(
	author_id int not null auto_increment primary key,
    author_name varchar(30) not null
);
create table BOOK_AUTHOR(
	author_id int,
    isbn bigint(13),
    constraint pk_author_isbn_book_author primary key (author_id, isbn)
);
create table PUBLISHER_DETAILS(
	publisher_id int not null auto_increment primary key,
    publisher_name varchar(50) not null
);
create table BOOK_CATEGORY_DETAILS(
	category_id int not null primary key auto_increment,
    category_name varchar(30) not null,
	category_description varchar(1000)
);
create table TICKET(
    borrowed_date date not null,
    ticket_id int not null primary key auto_increment,
    user_id int not null,
    borrow_number int not null
);
create table TICKET_BOOK(
	isbn bigint(13) not null,
    ticket_id int not null,
    primary key (isbn, ticket_id)
);
create table STAFF_INFO(
	staff_id int not null primary key auto_increment,
    real_name varchar(30) not null,
    address varchar(30) not null,
    phone_number int(11) not null,
    email varchar(30),
    pword int(20) not null,
    sex varchar(6),
    degree varchar(30),
    dayofbirth date
);
create table ROLE(
	role_id int not null auto_increment primary key,
    role_name varchar(20) not null
);
create table USER_INFO(
	user_id int not null auto_increment primary key,
    real_name varchar(30),
    address varchar(30),
    phone_number int(11),
    email varchar(30) not null,
    pword varchar(255) not null,
    sex varchar(6),
    job varchar(30),
    degree varchar(30),
    valid boolean,
    dayofbirth date
);
create table USER_ROLE(
	user_id int not null,
    role_id int not null,
    primary key (user_id, role_id)
);
create table RETURN_BOOK(
	return_book_id int not null primary key auto_increment,
	user_id int not null,
    returned_date date not null,
    fine int not null
);
create table PAYMENT(
	user_id int not null,
    payment_amount int not null,
    pay_day date not null,
    fine int,
    payment_id int primary key not null auto_increment
);
create table RULES(
	rule_id int(1) not null primary key,
    borrowing_time int not null,
    fine_per_day int not null,
    min_left int not null
);

alter table BOOK 
add constraint category_id_fk_on_book foreign key (category_id) references BOOK_CATEGORY_DETAILS(category_id);
alter table BOOK
add constraint publisher_id_fk_on_book foreign key (publisher_id) references PUBLISHER_DETAILS(publisher_id);
alter table BOOK 
add constraint importance_fk_on_book foreign key (importance) references RULES(rule_id);
alter table BOOK_AUTHOR
add constraint isbn_fk_on_book_author foreign key (isbn) references BOOK(isbn);
alter table BOOK_AUTHOR
add constraint author_id_fk_on_book_author foreign key (author_id) references AUTHOR_DETAILS(author_id);
alter table PAYMENT
add constraint user_id_fk_on_payment foreign key (user_id) references USER_INFO(user_id);
alter table USER_ROLE
add constraint user_id_fk_on_user_role foreign key (user_id) references USER_INFO(user_id);
alter table USER_ROLE
add constraint role_id_fk_on_user_role foreign key (role_id) references ROLE(role_id);
alter table TICKET
add constraint user_id_fk_on_ticket foreign key (user_id) references USER_INFO(user_id);
alter table TICKET_BOOK
add constraint ticket_id_fk_on_ticket_book foreign key (ticket_id) references TICKET(ticket_id);
alter table TICKET_BOOK
add constraint isbn_fk_on_ticket_book foreign key (isbn) references BOOK(isbn);
alter table RETURN_BOOK
add constraint user_id_fk_on_return foreign key (user_id) references TICKET(user_id);

insert into rules (rule_id, borrowing_time, fine_per_day, min_left) values (1, 0, 200000, 5);
insert into rules (rule_id, borrowing_time, fine_per_day, min_left) values (2, 7, 30000, 3);
insert into rules (rule_id, borrowing_time, fine_per_day, min_left) values (3, 15, 10000, 1);

insert into book_category_details(category_name) value ("Magazine");
insert into book_category_details(category_name) value ("Fiction");
insert into book_category_details(category_name) value ("History");
insert into book_category_details(category_name) value ("Science");
insert into book_category_details(category_name) value ("Psychology");
insert into book_category_details(category_name) value ("Economics");
insert into book_category_details(category_name) value ("Politics");
insert into book_category_details(category_name) value ("Manga");
insert into book_category_details(category_name) value ("Magazine");
insert into book_category_details(category_name) value ("Novel");
insert into book_category_details(category_name) value ("Cookbook");
insert into book_category_details(category_name) value ("Foreign Language");

insert into publisher_details(publisher_name) value ("Van hoc");
insert into publisher_details(publisher_name) value ("Hoi nha van");
insert into publisher_details(publisher_name) value ("Phu nu");
insert into publisher_details(publisher_name) value ("Hong Duc");
insert into publisher_details(publisher_name) value ("Ha Noi");
insert into publisher_details(publisher_name) value ("Tong hop thanh pho Ho Chi Minh");
insert into publisher_details(publisher_name) value ("Thanh nien");
insert into publisher_details(publisher_name) value ("Tre");
insert into publisher_details(publisher_name) value ("Dai hoc Quoc gia thanh pho Ho Chi Minh");
insert into publisher_details(publisher_name) value ("Kim Dong");
insert into publisher_details(publisher_name) value ("The duc the thao");
insert into publisher_details(publisher_name) value ("Phuong Nam Book");
insert into publisher_details(publisher_name) value ("Amak Books");
insert into publisher_details(publisher_name) value ("Quang Van Books");
insert into publisher_details(publisher_name) value ("Thai Ha Books");
insert into publisher_details(publisher_name) value ("IPM");
insert into publisher_details(publisher_name) value ("TABOOK");
insert into publisher_details(publisher_name) value ("Vintage");
insert into publisher_details(publisher_name) value ("International Publishers Co");
insert into publisher_details(publisher_name) value ("Rodale Books");
insert into publisher_details(publisher_name) value ("Smithsonian Books");
insert into publisher_details(publisher_name) value ("Cambridge University Press");
insert into publisher_details(publisher_name) value ("Haole Library");
insert into publisher_details(publisher_name) value ("Scholastic Press");
insert into publisher_details(publisher_name) value ("Oxford University Press");
insert into publisher_details(publisher_name) value ("James Leasor Publishing");
insert into publisher_details(publisher_name) value ("TokyoPop");
insert into publisher_details(publisher_name) value ("Yen On");
insert into publisher_details(publisher_name) value ("HMH Books for Young Readers");
insert into publisher_details(publisher_name) value ("Penguin Books");

insert into author_details(author_name) value ("Winston Groom");
insert into author_details(author_name) value ("Dominic Midgley");
insert into author_details(author_name) value ("Chris Hutchins");
insert into author_details(author_name) value ("Cuu Ba Dao");
insert into author_details(author_name) value ("Krishnamurti");
insert into author_details(author_name) value ("Hu Min");
insert into author_details(author_name) value ("John Gordon");
insert into author_details(author_name) value ("Ly A Tan");
insert into author_details(author_name) value ("Ta Chi Dai Tuong");
insert into author_details(author_name) value ("Nguyen Tan Dang");
insert into author_details(author_name) value ("Nguyen Xuan Truong");
insert into author_details(author_name) value ("Tatsuhiko Takimoto");
insert into author_details(author_name) value ("Nomura Mizuki");
insert into author_details(author_name) value ("Yoshiharu Tsuboi");
insert into author_details(author_name) value ("Philippe Devillers");
insert into author_details(author_name) value ("Shinkai Makoto");
insert into author_details(author_name) value ("Natsuki Namiya");
insert into author_details(author_name) value ("Arikawa Hiro");
insert into author_details(author_name) value ("Mikami En");
insert into author_details(author_name) value ("Eita Nakatani");
insert into author_details(author_name) value ("Eto Mori");
insert into author_details(author_name) value ("Dazai Osamu");
insert into author_details(author_name) value ("Tanigawa Nagaru");
insert into author_details(author_name) value ("Riku Misora");
insert into author_details(author_name) value ("Kenji Inoue");
insert into author_details(author_name) value ("Chihaya Akane");
insert into author_details(author_name) value ("Inui Kurumi");
insert into author_details(author_name) value ("Yukito Ayatsuji");
insert into author_details(author_name) value ("Hasekura Isuna");
insert into author_details(author_name) value ("Suzumu");
insert into author_details(author_name) value ("Ichikawa Takuji");
insert into author_details(author_name) value ("Yonejawa Honobu");
insert into author_details(author_name) value ("Iwai Shunji");
insert into author_details(author_name) value ("Reki Kawahara");
insert into author_details(author_name) value ("Gosho Aoyama");
insert into author_details(author_name) value ("Naoshi Arakawa");
insert into author_details(author_name) value ("Yoshitoki Oima");
insert into author_details(author_name) value ("Krishnamurti");
insert into author_details(author_name) value ("Kouji Seo");
insert into author_details(author_name) value ("Karl Marx");
insert into author_details(author_name) value ("Friedrich Engels");
insert into author_details(author_name) value ("Adolf Hitler");
insert into author_details(author_name) value ("Thug Kitchen LLC");
insert into author_details(author_name) value ("Darren Naish");
insert into author_details(author_name) value ("Brett L. Walker");
insert into author_details(author_name) value ("J. K. Rowling");
insert into author_details(author_name) value ("Duane W. Roller");
insert into author_details(author_name) value ("Wataru Watari");
insert into author_details(author_name) value ("Jasper Fforde");

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786045332641, "Schoolgirl",2,2015,2,"Essentially the start of Dazai's career, Schoolgirl gained notoriety for its ironic and inventive use of language",0,true,5,1);
insert into book_author(author_id, isbn) values (22,9786045332641);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786049143132, "5 Centimeters per Second",1,2014,10,"Praise for the animated film by Makoto Shinkai",0,true,5,1);
insert into book_author(author_id, isbn) values (16,9786049143132);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786041092969, "A Silent Voice 1",8,2016,8,"LEARNING TO LISTEN",0,true,15,1);
insert into book_author(author_id, isbn) values (37,9786041092969);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780307947390, "Forrest Gump",18,2012,10,"The modern classic that inspired the beloved movie starring Tom Hanks",0,true,10,1);
insert into book_author(author_id, isbn) values (1,9780307947390);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780717802418, "The Communist Manifesto",19,2014,7,"The Communist Manifesto, originally titled Manifesto of the Communist Party is a short 1848 book written by the German Marxist political theorists Karl Marx and Friedrich Engels",0,true,30,2);
insert into book_author(author_id, isbn) values (40,9780717802418);
insert into book_author(author_id, isbn) values (41,9780717802418);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781682040218, "Mein Kampf",23,2015,7,"Unabridged edition of Hitlers original book - Four and a Half Years of Struggle against Lies, Stupidity, and Cowardice",0,true,10,3);
insert into book_author(author_id, isbn) values (42,9781682040218);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781623363581, "Thug Kitchen: The Official Cookbook",20,2014,11,"Eat Like You Give a F*ck",0,true,25,1);
insert into book_author(author_id, isbn) values (43,9781623363581);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781588345820, "Dinosaurs: How They Lived and Evolved",21,2016,4,"Dinosaurs are one of the most spectacular groups of animals that have ever existed. Many were fantastic, bizarre creatures that still capture our imagination: the super-predator Tyrannosaurus, the plate-backed Stegosaurus, and the long-necked, long-tailed Diplodocus.",0,true,15,1);
insert into book_author(author_id, isbn) values (44,9781588345820);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780521178723, "A Concise History of Japan",21,2015,6,"A Concise History of Japan integrates the pageantry of Japanese history",0,true,12,2);
insert into book_author(author_id, isbn) values (45,9780521178723);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876046456568, "SOUL 26",7,2017,1,"Japanese 2D cultural subject",0,true,30,1);
insert into book_author(author_id, isbn) values (11,9876046456568);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876045635209, "Book of the end 1",3,2016,2,"Find the true meaning of life",0,true,10,1);
insert into book_author(author_id, isbn) values (30,9876045635209);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876045636107, "Book of the end 2",3,2016,2,"What color is the first page?",0,true,10,1);
insert into book_author(author_id, isbn) values (30,9876045636107);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9874045636763, "Book of the end 3",3,2016,2,"So, a new story begins",0,true,10,1);
insert into book_author(author_id, isbn) values (30,9874045636763);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876045638088, "Book of the end 4",3,2016,2,"We are nearing the end",0,true,10,1);
insert into book_author(author_id, isbn) values (30,9876045638088);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780590353403, "Harry Potter And The Sorcerer's Stone",24,1998,2,"What did Harry Potter know about magic?",0,true,20,2);
insert into book_author(author_id, isbn) values (46,9780590353403);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780439064866, "Harry Potter and the Chamber of Secrets",24,1999,2,"In one of the most hotly anticipated sequel in memory",0,true,20,2);
insert into book_author(author_id, isbn) values (46,9780439064866);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786045835807, "IELTS Listening Strategies for the Ielts Test",6,2011,12,"",0,true,30,1);
insert into book_author(author_id, isbn) values (8,9786045835807);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876045809747, "Essential Grammer for IELTS",6,2015,12,"",0,true,32,1);
insert into book_author(author_id, isbn) values (6,9876045809747);
insert into book_author(author_id, isbn) values (7,9876045809747);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786048554071, "IELTS Writing Strategies for the Ielts Test",6,2015,12,"",0,true,36,1);
insert into book_author(author_id, isbn) values (6,9786048554071);
insert into book_author(author_id, isbn) values (7,9786048554071);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781570624421, "This Light in Oneself",25,1999,5,"These selections present the core of Krishnamurti's teaching on meditation, taken from discussions with small groups",0,true,8,2);
insert into book_author(author_id, isbn) values (38,9781570624421);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9876046915577, "Book Girl and the Suicidal Mime",1,2014,2,"For Tohko Amano, a third-year high school student and self-styled book girl, being the head of the literary club is more than just an extracurricular activity. It's her bread and butter...literally! Tohko is actually a literature-gobbling demon, who can be found at all hours of the day munching on torn out pages from all kinds of books. But for Tohko, the real delicacies are hand-written stories. To satisfy her gourmet tastes, she's employed (rather, browbeaten) one Konoha Inoue, who scribbles away each day after school to satisfy Tohko's appetite. But when another student comes knocking on the literary club door for advice on writing love letters, will Tohko discover a new kind of delicacy?",0,true,18,1);
insert into book_author(author_id, isbn) values (13,9876046915577);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781908291585, "Abramovich: The Billionaire from Nowhere",26,2015,6,"Roman Abramovich, the billionaire owner of Chelsea FC, was a penniless orphan who rose from the ashes of Soviet Russia to become one of the richest and most powerful men in the world. His fascinating life story has been shrouded in mystery  until now. Journalists Dominic Midgley and Chris Hutchins get to grips with the Russian boss of Chelsea FC, who has revolutionised English football since he bought the club in the summer of 2003, since when it has won two Premiership titles",0,true,13,1);
insert into book_author(author_id, isbn) values (2,9781908291585);
insert into book_author(author_id, isbn) values (3,9781908291585);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9781427802569, "Welcome to the NHK",27,2007,10,"The novel that inspired the manga and anime!Twenty-two-year-old Satou, a college dropout and aficionado of anime porn, knows a little secret--or at least he thinks he does! Believe it or not, he has stumbled upon an incredible conspiracy created by the Japanese Broadcasting Company, N.H.K. But despite fighting the good fight, Satou has become an unemployed hikikomori--a shut-in who has withdrawn from the world....",0,true,30,1);
insert into book_author(author_id, isbn) values (12,9781427802569);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786049143144, "The Sigh of Haruhi Suzumiya",1,2014,2,"The bestselling series that took the world by storm continues with this hilarious and sly second book. As the SOS Brigade prepares for the upcoming cultural festival, eccentric high school student and oblivious god Haruhi decides to make a movie. The star-the beautiful and reluctant Mikuru",0,true,22,1);
insert into book_author(author_id, isbn) values (23,9786049143144);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786046943693, "The Disappearance of Haruhi Suzumiya",1,2015,2,"It's one week before Christmas Eve, and Haruhi and the S.O.S. Brigade (a club for her high school's strangest and most extraordinary students) are gearing up for holiday festivities. But just before the fun kicks off, Kyon, the only normal member, wakes up in a weird alternate dimension, one where Haruhi attends another school entirely, Nagato the time traveling robot is just an ordinary human, and Mikuru (the cute girl of Kyon's dreams) doesn't even recognize him-in other words, S.O.S. Brigade never existed",0,true,24,1);
insert into book_author(author_id, isbn) values (23,9786046943693);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786046978190, "Sword Art Online 4: Fairy Dance",1,2016,10,"Kirito plunges into a suspicious new VRMMORPG called ALfheim Online to rescue Asuna, who never returned from Sword Art Online. ALO offers many features to entertain players in the wake of SAO: ultra-high-end graphics, action-heavy gameplay, a choice of fairy races, and a next-generation flight engine. Playing as a spriggan, Kirito heads for the location of Asuna's prison--the top of the World Tree, the final destination of every player in the game!",0,true,30,1);
insert into book_author(author_id, isbn) values (34,9786046978190);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786046992219, "Sword Art Online 5: Phantom Bullet",1,2016,10,"Kirito reenters the world of VRMMOs, this time logging in to Gun Gale Online in order to investigate the Death Gun, an in-game item rumored to be responsible for real-world deaths. He immediately runs into trouble when, after transferring his old avatar into the new game, he discovers that he looks a bit more feminine than he'd anticipated!",0,true,30,1);
insert into book_author(author_id, isbn) values (34,9786046992219);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786045365465, "Hyouka",2,2016,10,"Though he had no interest whatsoever in joining any clubs upon entering Kamiyama High School, he was commanded by his older sister Tomoe to enter the school's Classics Club, which was in danger of getting abolished as all previous members have graduated. Together with his old friends Satoshi Fukube and Mayaka Ibara, as well as the elegantly ladylike and curiously inquisitive Eru Chitanda, the newly reformed Classics Club find themselves involved in all sorts of mystery-solving escapades",0,true,15,1);
insert into book_author(author_id, isbn) values (8,9786045365465);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780316312295, "My Youth Romantic Comedy Is Wrong as I Expected, Vol. 1",28,2016,10,"Hachiman Hikigaya is a cynic. Youth is a crock, he believes--a sucker's game, an illusion woven from failure and hypocrisy. But when he turns in an essay for a school assignment espousing this view, he's sentenced to work in the Service Club, an organization dedicated to helping students with problems in their lives! How will Hachiman the Cynic cope with a job that requires--gasp!--optimism?",0,true,37,1);
insert into book_author(author_id, isbn) values (48,9780316312295);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780316396011, "My Youth Romantic Comedy Is Wrong as I Expected, Vol. 2",28,2016,10,"As usual, Hachiman Hikigaya's warped personality prevents him from having any enjoyable moments of youth. The days all the seem the same until suddenly, an 'incident' occurs in class. This is a problem that no one who had any semblance of a normal high school life could solve, but if it's Hachiman, just maybe...",0,true,34,1);
insert into book_author(author_id, isbn) values (48,9780316396011);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780316553377, "Konosuba: God's Blessing on This Wonderful World!",28,2017,10,"Game loving shut-in Kazuma Sato's life as a young schoolboy in Japan abruptly comes to an early end...or at least it was supposed to. When he opens his eyes, though, he sees a beautiful goddess that offers him a once in an after-lifetime chance to be reborn in a parallel world. The catch is that the world is violent and threatened by a growing evil! Fortunately, he can choose any one thing to bring with him. So he chooses the goddess, Aqua! ",0,true,30,1);
insert into book_author(author_id, isbn) values (50,9780316553377);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780316468701, "Konosuba: God's Blessing on This Wonderful World! Love, Witches & Other Delusions!",28,2017,10,"",0,true,30,1);
insert into book_author(author_id, isbn) values (50,9780316468701);	

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9786045357255, "Colorful",2,2015,10,"",0,true,26,1);
insert into book_author(author_id, isbn) values (21,9786045357255);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780143037231, "The Big Over Easy: A Nursery Crime",30,2007,2,"Jasper Fforde's bestselling Thursday Next series has delighted readers of every genre with its literary derring-do and brilliant flights of fancy. In The Big Over Easy, Fforde takes a break from classic literature and tumbles into the seedy underbelly of nursery crime. Meet Inspector Jack Spratt, family man and head of the Nursery Crime Division. He's investigating the murder of ovoid D-class nursery celebrity Humpty Dumpty, found shattered to death beneath a wall in a shabby area of town",0,true,22,1);
insert into book_author(author_id, isbn) values (49,9780143037231);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780143038924, "The Fourth Bear: A Nursery Crime",30,2007,2,"The inimitable Jasper Fforde gives readers another delightful mash-up of detective fiction and nursery rhyme, returning to those mean streets where no character is innocent. The Gingerbreadman—sadist, psychopath, cookie—is on the loose in Reading, but that’s not who Detective Jack Spratt and Sergeant Mary Mary are after. Instead, they’ve been demoted to searching for missing journalist “Goldy” Hatchett. The last witnesses to see her alive were the reclusive Three Bears, and right away Spratt senses something furry—uh, funny—about their story, starting with the porridge. The Fourth Bear is a delirious new romp from our most irrepressible fabulist.",0,true,20,1);
insert into book_author(author_id, isbn) values (49,9780143038924);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780143113560, "First Among Sequels",30,2008,2,"The fifth installment in Jasper Fforde’s New York Times bestselling series follows literary detective Thursday Next on another adventure in her alternate reality of literature-obsessed England",0,true,17,1);
insert into book_author(author_id, isbn) values (49,9780143113560);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780143120513, "One of Our Thursdays Is Missing: A Thursday Next Novel",30,2012,10,"The New York Times bestseller and the wildly inventive sixth installment of a series that has more than one million copies (and counting) in print. ",0,true,30,1);
insert into book_author(author_id, isbn) values (49,9780143120513);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780147509765, "The Woman Who Died a Lot: A Thursday Next Novel",30,2013,2,"With more than one million books in print worldwide, Jasper Fforde’s beloved series charms a growing number of readers with each new adventure. In The Woman Who Died a Lot, Thursday Next faces her trickiest assignment yet.",0,true,18,1);
insert into book_author(author_id, isbn) values (49,9780147509765);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780544104716, "The Last Dragonslayer: The Chronicles of Kazam",29,2013,2,"In the good old days, magic was indispensable. But now magic is fading: Drain cleaner is cheaper than a spell, and magic carpets are used for pizza delivery. Fifteen-year-old Jennifer Strange runs Kazam, an employment agency for magicians—but it’s hard to stay in business when magic is drying up. And then the visions start, predicting the death of the world’s last dragon at the hands of an unnamed Dragonslayer. If the visions are true, everything will change for Kazam—and for Jennifer.",0,true,30,1);
insert into book_author(author_id, isbn) values (49,9780544104716);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780143118589, "Shades of Grey: A Novel",30,2011,10,"Welcome to Chromatacia, where the societal hierarchy is strictly regulated by one's limited color perception. And Eddie Russet wants to move up. But his plans to leverage his better-than-average red perception and marry into a powerful family are quickly upended. Juggling inviolable rules, sneaky Yellows, and a risky friendship with an intriguing Grey named Jane who shows Eddie that the apparent peace of his world is as much an illusion as color itself, Eddie finds he must reckon with the cruel regime behind this gaily painted façade.",0,true,30,1);
insert into book_author(author_id, isbn) values (49,9780143118589);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780544336629, "The Song of the Quarkbeast: The Chronicles of Kazam",29,2014,2,"Magic has been in a sad state in the Ununited Kingdom for years, but now it’s finally on the rise, and boneheaded King Snodd IV knows it. If he succeeds at his plot, the very future of magic will be at risk! Sensible sixteen-year-old Jennifer Strange, acting manager of Kazam Mystical Arts Management and its unpredictable crew of sorcerers, has little chance against the king and his cronies—but there’s no way Kazam will let go of the noble powers of magic without a fight. A suspenseful, satirical story of Quarkbeasts, trolls, and wizidrical crackle!",0,true,18,1);
insert into book_author(author_id, isbn) values (49,9780544336629);

insert into book(isbn, title, publisher_id, publishing_year, category_id, short_description, brw_tckt_nber, valid_status, amount, importance)
values (9780544540712, "The Eye of Zoltar",29,2015,2,"Although she’s an orphan in indentured servitude, sixteen-year-old Jennifer Strange is pretty good at her job of managing the unpredictable crew at Kazam Mystical Arts Management. She already solved the Dragon Problem, avoided mass destruction by Quarkbeast, and helped save magic in the Ununited Kingdoms. Yet even Jennifer may be defeated when the long-absent Mighty Shandar makes an astonishing appearance and commands her to find the Eye of Zoltar—proclaiming that if she fails, he will eliminate the only two dragons left on earth.",0,true,24,1);
insert into book_author(author_id, isbn) values (49,9780544540712);


