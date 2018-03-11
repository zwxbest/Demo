-- from后必须根table_referrnce;
-- 经过搜索和实践，function并不能返回table,此方案行不通
-- drop function if exists SelectSCByCid;
-- 
-- -- 因为sql默认的语句分隔符为;,client传输到server时,遇到;便执行，我们需要整个函数传输过去才执行。
-- -- 所以必须改变默认的语句分隔符，之后再改回来
-- 
-- DELIMITER $$
-- CREATE FUNCTION SelectSCByCid (cid int) 
-- returns varchar(300)
-- begin 
-- return concat('select sid,score from SC where cid=',cid);
-- END$$
-- 
-- -- 必须还原，否则后面的都以$$为语句分隔符，否则后面用;会报错
-- 
-- DELIMITER ;

-- 经过搜索，存储过程可以产生table，但是并不能from call SelectSCByCid(1),也不能from SelectSCByCid(1)
-- 因为存储过程并没有返回值
-- DROP PROCEDURE IF EXISTS SelectSCByCid;
-- DELIMITER $$
-- CREATE PROCEDURE SelectSCByCid( cid INT )
-- BEGIN  
--    select sid,score from SC where cid=cid;
-- END$$
-- DELIMITER ;
-- 

-- 1、查询“1”课程比“2”课程成绩高的所有学生的学号； 

-- select course_1.sid as '“1”课程比“2”课程成绩高的所有学生的学号'
-- from  (select sid,score from sc where cid=1) course_1 ,(select sid,score from sc where cid=2) course_2
-- where course_1.sid=course_2.sid and course_1.score>course_2.score;

-- 2、查询平均成绩大于60分的同学的学号和平均成绩；
--  select sid as '平均成绩大于60分的同学的学号',avg(score) as '平均成绩大于60分的同学的学平均成绩'
--     from sc 
--     group by sid 
--     having avg(score) >60; 

-- 3、查询所有同学的学号、姓名、选课数、总成绩；
 
-- select sc.sid,sname,count(1),sum(score)
-- from student,sc,course
-- where student.sid=sc.sid and sc.cid=course.cid
-- group by sc.sid;

-- 4、查询姓“李”的老师的个数； 

-- select count(1)
-- from teacher
-- where tname like '李%';

-- 5、查询没学过“叶平”老师课的同学的学号、姓名；

-- select sid as '没学过“叶平”老师课的同学的学号',sname
-- from student
-- where sid not in
--  (select sid from sc,course,teacher where sc.cid=course.cid and teacher.tid=course.tid and teacher.tname='叶平');
 
 -- 6、查询学过“1”并且也学过编号“2”课程的同学的学号、姓名；
 
-- select  sc.sid as '学过“1”并且也学过编号“2”课程的同学的学号', sname
-- from student,sc
-- where student.sid=sc.sid and sc.cid=1 and exists 
-- (select sc_2.sid from sc as sc_2 where sc_2.sid=student.sid and sc_2.cid=2);

-- select sc.sid as '学过“1”并且也学过编号“2”课程的同学的学号',sname
-- from student,sc
-- where student.sid=sc.sid and (sc.cid=1 or sc.cid=2)
-- group by sc.sid having count(1)=2 

-- 7、查询学过“叶平”老师所教的所有课的同学的学号、姓名；
 
--   select sid as '学过“叶平”老师所教的所有课的同学的学号',Sname 
--   from Student 
--   where sid in 
--   (select sid from sc ,course ,teacher where sc.cid=course.cid  and teacher.tid=course.tid and teacher.tname='叶平' 
--   group by sid having count(1)=(select count(1) from course,teacher  where teacher.tid=course.tid and tname='叶平')); 
  
-- 9、查询所有课程成绩小于60分的同学的学号、姓名； 

-- select s.sid,sname 
-- from student s,sc
-- where s.sid=sc.sid 
-- group by sc.sid
-- having max(score)<60;

-- 10、查询没有学全所有课的同学的学号、姓名； 

-- select s.sid
-- from student s,course c
-- where c.cid not in 
-- (select sc.cid from sc where s.sid=sc.sid) ; 

-- 11、查询至少有一门课与学号为“1”的同学所学相同的 同学的学号和姓名； 
-- 查到一门课外层循环就break，用存储过程
-- select distinct s.sid,sname
-- from student s,sc
-- where s.sid=sc.sid and sc.cid in
-- (select cid from student s_2,sc sc_2 where s_2.sid=sc_2.sid and sc_2.sid=1)





 








