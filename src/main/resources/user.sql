CREATE TABLE IF NOT EXISTS users(
	userid 		varchar(12)	not null,
	password	varchar(12)	not null,
	name		varchar(20)	not null,
	email		varchar(50)	,
	
	primary key (userid)
);

--insert into users values('astraltear','password','아스트랄티어','astral@tear.com');