drop table if exists student;
CREATE TABLE student 
  ( 
     sid    INT, 
     sname nvarchar(32), 
     sage  INT, 
     ssex  nvarchar(8) 
  ) ;

drop table if exists course;

CREATE TABLE course 
  ( 
     cid    INT, 
     cname nvarchar(32), 
     tid   INT 
  ) ;
  drop table if exists sc;


CREATE TABLE sc 
  ( 
     sid    INT, 
     cid   INT, 
     score double 
  ) ;
  drop table if exists teacher;

CREATE TABLE teacher 
  ( 
     tid    INT, 
     tname nvarchar(16) 
  ) ;
  
  
  
insert into Student 
 select 1,N'刘一',18,N'男' union 
 select 2,N'钱二',19,N'女' union 
 select 3,N'张三',17,N'男' union 
 select 4,N'李四',18,N'女' union 
 select 5,N'王五',17,N'男' union 
 select 6,N'赵六',19,N'女' ;
 
 insert into Teacher 
 select 1,N'叶平' union 
 select 2,N'贺高' union 
 select 3,N'杨艳' union 
 select 4,N'周磊';
 
 insert into Course 
 select 1,N'语文',1 union 
 select 2,N'数学',2 union 
 select 3,N'英语',3 union 
 select 4,N'物理',4;
 
 insert into SC 
 select 1,1,56 union 
 select 1,2,78 union 
 select 1,3,67 union 
 select 1,4,58 union 
 select 2,1,79 union 
 select 2,2,81 union 
 select 2,3,92 union 
 select 2,4,68 union 
 select 3,1,91 union 
 select 3,2,47 union 
 select 3,3,88 union 
 select 3,4,56 union 
 select 4,2,88 union 
 select 4,3,90 union 
 select 4,4,93 union 
 select 5,1,46 union 
 select 5,3,78 union 
 select 5,4,53 union 
 select 6,1,35 union 
 select 6,2,68 union 
 select 6,4,71;