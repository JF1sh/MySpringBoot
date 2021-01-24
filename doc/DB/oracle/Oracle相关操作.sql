

-- 查询sy_org_user 表中有过更新的数据

select * from  sy_org_user
versions BETWEEN TIMESTAMP minvalue AND maxvalue WHERE versions_starttime IS NOT NULL ORDER BY versions_starttime DESC



--给所查出来的值赋值

select decode(user_sex,1,'男',2,'女') from sy_org_user


--条件筛选 case when

select sum(case when s_flag ='1' then 1 else 0 end ) from sy_org_dept ; --默认统计为1的值

select dept_name,s_flag, (case when s_flag='1' then 'ok' when s_flag ='0' then 'no' else 'go' end) from sy_org_dept ;


--字符串截取
-- 从第12位开始截取，截取10位。 如果i为负数，则表示从字符串的最右边第i位开始截取，从左到右10位。
select substr(a.code_path,12,10) from sy_org_dept a


--在多条重复数据中取时间最新的那条
-- partition by 后加以哪个重复的字段
-- order by  后加时间字段 会根据最新的时间 显示1，2，3
select t.SG_ID,row_number() over (partition by t.SG_ID order by t.s_mtime) as row_flg from SY_BASE_BANK 

--row_number() 记录查询的数据生成一个序号
--over() 选择哪一列数据进行排序，与row_number()一起用
--partition by 与 order by 一起用，表示以什么分片 以什么排序(显示所有数据)
--group by 将查询的数据根据字段分组后 取一条。


--查询vaule为纯数字的数据
select * from where regexp_like(vale,'^[[:digit:]]+$');