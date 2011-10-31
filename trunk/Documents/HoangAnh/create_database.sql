create database Doctor_Information_System
go
-- drop database Doctor_Information_System
use Doctor_Information_System
go

create table Professional
(
	Professional_ID		int identity(1,1) primary key,
	Professional_name	nvarchar(30),
)
go

create table Qualification
(
	Qualification_ID	int identity(1,1) primary key,
	Qualification_name	nvarchar(10),
)
go

create table Country
(
	Country_ID		int identity(1,1) primary key,
	Country_name	nvarchar(20),
)
go

create table City
(
	City_ID		int identity(1,1) primary key,
	City_name	nvarchar(20),
	Country_ID	int
)
go

create table Achievement
(
	Achievement_ID		int identity(1,1) primary key,
	Doctor_ID			int,
	Description			nvarchar(70),
)
go

create table Doctor
(
	Doctor_ID			int identity(1,1) primary key,
	first_name			nvarchar(20),
	last_name			nvarchar(20),
	address				nvarchar(50),
	Professional_id		int,
	Qualification_id	int,
	City_id				int,
	phone_number		nvarchar(15),
	birthday			smalldatetime,
	sex					nvarchar(5),
	experience			int
)
go

create table History_doctor
(	
	History_ID		int identity(1,1) primary key,
	doctor_id		int,
	from_date		smalldatetime,
	to_date			smalldatetime,
)
go

create table Login
(	
	id				int identity(1,1),
	username		nvarchar(20) primary key,
	password		nvarchar(20),
	active			int,
	is_admin		int,
)
go