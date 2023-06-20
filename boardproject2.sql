
--create table board_info_table(
--    board_info_idx number constraint BOARD_INFO_FK primary key,
--    board_info_name varcharw(500) not null
--);

-- board_info_table 테이블 생성
create table board_info_table (
    board_info_idx number not null primary key,
    board_info_name varchar2(500) not null
);   

insert into board_info_table values (1, '자유게시판');
insert into board_info_table values (2, '유머게시판');
insert into board_info_table values (3, '정치게시판');
insert into board_info_table values (4, '스포츠게시판');

select * from board_info_table order by board_info_idx;
commit;



-- create table user_table(
--  user_idx number constraint USER_FK primary key,
--  user_name varchar2(50) not null,
--  user_id varchar2(100) not null,
--  user_pw varchar2(100) not null
--  );

-- user_table 테이블 생성    
create table user_table (
    user_idx number not null primary key,
    user_name varchar2(50) not null,
    user_id varchar2(100) not null,
    user_pw varchar2(100) not null
);



-- content_table 테이블 생성
create table content_table (
    content_idx number not null primary key,
    content_subject varchar2(500) not null,
    content_text long not null,
    content_file varchar2(500),
    content_writer_idx number not null constraint CONTENT_FK1 references user_table(user_idx),
    content_board_idx number not null constraint CONTENT_FK2 references board_info_table(board_info_idx),
    content_date date not null
);

--alter table content_table add constraint pk1 foreign key(content_writer_idx) references user_table(user_idx);
--alter table content_table add constraint pk2 foreign key(content_board_idx) references board_info_table(board_info_idx);

commit;

-- sequence 생성
create sequence user_seq start with 0 increment by 1 minvalue 0;
create sequence content_seq start with 0 increment by 1 minvalue 0;


















    