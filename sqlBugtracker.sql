create database bugtracker;
use bugtracker;
create table admin(
adminId varchar(50),
adminName varchar(50),
age int 
);
create table staff(
staffId varchar(50),
staffName varchar(50)
);
create table user(
userId varchar(50),
userName varchar(50)
);
create table bug(
bugId varchar(50),
bugName varchar(50),
bugReportday datetime
)