drop table customer;

create table customer(
	id varchar2(10) primary key,
	pw varchar2(10) not null,
	name varchar2(10) not null
);

insert into customer values('tester', '11', '신동엽');
insert into customer values('power', '22', '이영자');

commit;

select * from customer;