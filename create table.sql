create table tbl_board (
	bno INT not null AUTO_INCREMENT,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    regdate timestamp not null default now(),
    viewcnt int default 0,
    primary key (bno)
);


create table tbl_reply (
	rno int not null auto_increment,
    bno int not null default 0,
    replytext varchar(1000) not null,
    replyer varchar(50) not null,
    regdate timestamp not null default now(),
    updatedate timestamp not null default now(),
    primary key(rno)
);


alter table tbl_reply add constraint fk_board
foreign key(bno) references tbl_board(bno)
;


create table tbl_user (
	uid varchar(50) not null,
    upw varchar(50) not null,
    uname varchar(100) not null,
    upoint int not null default 0,
    primary key(uid)
)
;

create table tbl_message (
	mid int not null auto_increment,
    targetid varchar(50) not null,
    sender varchar(50) not null,
    message text not null,
    opendate timestamp,
    senddate timestamp not null default now(),
    primary key(mid)
)
;


alter table tbl_message add constraint fk_usertarget
foreign key (targetid) references tbl_user (uid);

alter table tbl_message add constraint fk_usersender
foreign key (targetid) references tbl_user (uid);


insert into tbl_user (uid, upw, uname) values ('user00', 'user00', 'IRON MAN');
insert into tbl_user (uid, upw, uname) values ('user01', 'user01', 'CAPTAIN');
insert into tbl_user (uid, upw, uname) values ('user02', 'user02', 'HULK');
insert into tbl_user (uid, upw, uname) values ('user03', 'user03', 'Thor');
insert into tbl_user (uid, upw, uname) values ('user10', 'user10', 'Quick Silver');


alter table tbl_board add column replycnt int default 0;


alter table tbl_user add column sessionkey varchar(50) not null default 'none';
alter table tbl_user add column sessionlimit timestamp;