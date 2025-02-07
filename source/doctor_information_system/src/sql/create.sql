CREATE TABLE [user_login] (
    [user_name] NVARCHAR(40) NOT NULL,
    [pass_word] NVARCHAR(20) NOT NULL,
    [active] INTEGER CONSTRAINT [DEF_user_active] DEFAULT 1 NOT NULL ,
    [role_id] INTEGER NOT NULL,
    CONSTRAINT [PK_user_login] PRIMARY KEY ([user_name])
)
GO
CREATE TABLE [functions] (
    [function_id] INTEGER IDENTITY NOT NULL,
    [function_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_functions] PRIMARY KEY ([function_id])
)
GO
CREATE TABLE [roles] (
    [role_id] INTEGER IDENTITY NOT NULL,
    [role_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_roles] PRIMARY KEY ([role_id])
)
GO
CREATE TABLE [roles_functions] (
    [role_id] INTEGER NOT NULL,
    [function_id] INTEGER NOT NULL,
    CONSTRAINT [PK_roles_functions] PRIMARY KEY ([role_id],[function_id])
)
GO
CREATE TABLE [history_doctor] (
    [history_id] INTEGER IDENTITY NOT NULL,
    [doctor_id] INTEGER NOT NULL,
    [from_date] smalldatetime NOT NULL,
    [to_date] smalldatetime,
    CONSTRAINT [PK_history_doctor] PRIMARY KEY ([history_id])
)
GO
CREATE TABLE [professional] (
    [professional_id] INTEGER IDENTITY NOT NULL,
    [professional_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_professional] PRIMARY KEY ([professional_id])
)
GO
CREATE TABLE [qualification] (
    [qualification_id] INTEGER IDENTITY NOT NULL,
    [qualification_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_qualification] PRIMARY KEY ([qualification_id])
)
GO
CREATE TABLE [country] (
    [country_id] INTEGER IDENTITY NOT NULL,
    [country_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_country] PRIMARY KEY ([country_id])
)
GO
CREATE TABLE [city] (
    [city_id] INTEGER IDENTITY NOT NULL,
    [city_name] NVARCHAR(255) NOT NULL,
	[country_id] INTEGER NOT NULL,
    CONSTRAINT [PK_city] PRIMARY KEY ([city_id])
)
GO
CREATE TABLE [achievement] (
    [achievement_id] INTEGER IDENTITY NOT NULL,
    [desciption] NVARCHAR(255) NOT NULL,
	[doctor_id] INTEGER NOT NULL,
    CONSTRAINT [PK_achievement] PRIMARY KEY ([achievement_id])
)
GO
CREATE TABLE [doctor] (
    [doctor_id] INTEGER IDENTITY NOT NULL,
    [first_name] NVARCHAR(40) NOT NULL,
	[last_name] NVARCHAR(40) NOT NULL,
	[add_ress] NVARCHAR(50) NOT NULL,
	[email] NVARCHAR(40) NOT NULL,
	[phone_number] NVARCHAR(25) NOT NULL,
	[birthday] smalldatetime NOT NULL,
	[sex] NVARCHAR(6) NOT NULL,
	[experience] INTEGER NOT NULL,
	[city_id] INTEGER NOT NULL,
	[qualification_id] INTEGER NOT NULL,
	[professional_id] INTEGER NOT NULL,
    CONSTRAINT [PK_doctor] PRIMARY KEY ([doctor_id])
)
GO
INSERT INTO [dbo].[roles]([role_name]) 
SELECT N'admin' UNION ALL 
SELECT N'employee'
GO
INSERT INTO [dbo].[functions]([function_name]) 
SELECT N'Search' UNION ALL 
SELECT N'Manage History Doctor' UNION ALL 
SELECT N'Manage Qualification' UNION ALL
SELECT N'Manage Country' UNION ALL 
SELECT N'Manage City' UNION ALL 
SELECT N'Manage Achievement' UNION ALL 
SELECT N'Manage Doctor' UNION ALL 
SELECT N'Manage Professional' UNION ALL 
SELECT N'Search History Visiting' UNION ALL 
SELECT N'Manage User'
GO
INSERT INTO [dbo].[roles_functions]([role_id],[function_id]) 
SELECT 1,1 UNION ALL 
SELECT 1,2 UNION ALL 
SELECT 1,3 UNION ALL 
SELECT 1,4 UNION ALL 
SELECT 1,5 UNION ALL 
SELECT 1,6 UNION ALL 
SELECT 1,7 UNION ALL 
SELECT 1,8 UNION ALL 
SELECT 1,9 UNION ALL 
SELECT 1,10 UNION ALL 
SELECT 2,1 UNION ALL 
SELECT 2,9
GO
INSERT INTO [dbo].[professional]([professional_name])
SELECT N'Professor' UNION ALL 
SELECT N'Associate Professor' UNION ALL 
SELECT N'Dr.' UNION ALL 
SELECT N'Masters'
GO
INSERT INTO [dbo].[qualification]([qualification_name])
SELECT N'Neurologist' UNION ALL
SELECT N'Obstetric' UNION ALL
SELECT N'Internal Medicine' UNION ALL
SELECT N'External medicine'
GO
INSERT INTO [dbo].[country]([country_name]) 
SELECT N'Vietnam' UNION ALL 
SELECT N'USA' UNION ALL 
SELECT N'Cambodia' UNION ALL 
SELECT N'Malaysia'
GO
INSERT INTO [dbo].[city]([city_name],[country_id]) 
SELECT N'TP.HCM',1 UNION ALL 
SELECT N'Ha Noi',1 UNION ALL 
SELECT N'New York',2 UNION ALL 
SELECT N'Kualar Lumpua',4 UNION ALL
SELECT N'Phnom Penh',3
GO
INSERT INTO [dbo].[doctor]([first_name],[last_name],[add_ress],[email],[phone_number],[sex],[birthday],[experience],[city_id],[qualification_id],[professional_id]) 
SELECT 'Cong','Nguyen Tan','1438D Pham The Hien F5 Q8','cong.nguyentan@codeandmore.com','01217604545','Male','12/27/1983',1,1,3,4 UNION ALL
SELECT 'Peter','Gravensen','285 Broadway','peter1977@yahoo.com','0425-415-5528','Male','10/15/1977',8,3,1,1 UNION ALL
SELECT 'Mei Mei','Kualar','115 Mataya','meimei@gmail.com','125-445-5142','Female','08/07/1980',4,4,4,3
GO
INSERT INTO [dbo].[history_doctor]([doctor_id],[from_date],[to_date])
SELECT 1,'11/15/2011','11/16/2011' UNION ALL
SELECT 1,'11/20/2011','12/01/2011' UNION ALL
SELECT 2,'09/05/2011','10/05/2011' UNION ALL
SELECT 2,'11/11/2011','12/11/2011'
GO
ALTER TABLE [user_login] ADD CONSTRAINT [role_user_login]
    FOREIGN KEY ([role_id]) REFERENCES [roles] ([role_id])
GO
ALTER TABLE [roles_functions] ADD CONSTRAINT [roles_roles_functions]
    FOREIGN KEY ([role_id]) REFERENCES [roles] ([role_id])
GO
ALTER TABLE [roles_functions] ADD CONSTRAINT [functions_roles_functions]
    FOREIGN KEY ([function_id]) REFERENCES [functions] ([function_id])
GO
ALTER TABLE [city] ADD CONSTRAINT [country_city]
    FOREIGN KEY ([country_id]) REFERENCES [country] ([country_id])
GO
ALTER TABLE [doctor] ADD CONSTRAINT [professional_doctor]
    FOREIGN KEY ([professional_id]) REFERENCES [professional] ([professional_id])
GO
ALTER TABLE [doctor] ADD CONSTRAINT [qualification_doctor]
    FOREIGN KEY ([qualification_id]) REFERENCES [qualification] ([qualification_id])
GO
ALTER TABLE [doctor] ADD CONSTRAINT [city_doctor]
    FOREIGN KEY ([city_id]) REFERENCES [city] ([city_id])
GO
ALTER TABLE [achievement] ADD CONSTRAINT [doctor_achievement]
    FOREIGN KEY ([doctor_id]) REFERENCES [doctor] ([doctor_id])
GO
ALTER TABLE [history_doctor] ADD CONSTRAINT [doctor_history_doctor]
    FOREIGN KEY ([doctor_id]) REFERENCES [doctor] ([doctor_id])
GO
IF EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME='spGetAllProfessional' AND TYPE ='P')
DROP PROC spGetAllProfessional
GO
create proc spGetAllProfessional
as
begin
select * from professional
end
GO
IF EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME = 'spInsertProfessional' AND TYPE = 'P')
DROP PROC spInsertProfessional
GO
create proc spInsertProfessional
@professional_name nvarchar(255)
as
begin
insert into professional
values (@professional_name)
end
GO
------------------------------------------
--create proc spUpdateProfessional--
IF EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME = 'spUpdateProfessional' AND TYPE ='P')
DROP PROC spUpdateProfessional
GO
create proc spUpdateProfessional
@professional_id integer,
@professional_name nvarchar(255)
as
begin
update professional
set professional_name = @professional_name
where professional_id = @professional_id
end
GO
----------------------------------------
--create proc spDeleteProfessional
IF EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME='spDeleteProfessional' AND TYPE='P')
DROP PROC spDeleteProfessional
GO
create proc spDeleteProfessional
@professional_id integer
as
begin
delete from professional
where professional_id = @professional_id
end
GO
-----------------proc-----------------------------------
create proc spAllAchievement
as
begin
select * from achievement
end
GO
--------------------------------
------------
create proc spInsertAchievement
@desciption nvarchar(225),
@doctor_id integer
as
begin
insert into achievement
values(@desciption,@doctor_id)
end
GO
------------------------------------
CREATE PROC spUpdateAchievement
@achie_id integer ,
@desciption nvarchar(225),
@doctor_id integer
AS
UPDATE achievement
SET desciption=@desciption,doctor_id=@doctor_id
WHERE achievement_id = @achie_id
GO
----------------
create proc spDeleteAchievement
@achievement_id integer
as
begin
delete from achievement
where achievement_id = @achievement_id
end
GO
-------------------------------------
CREATE PROC spGetAllDoctor
AS
SELECT * FROM doctor
GO
---------------------------------------