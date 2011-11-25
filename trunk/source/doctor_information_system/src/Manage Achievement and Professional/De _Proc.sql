
create database DBHoangDe
go
use DBHoangDe
go

---------------feind
DROP TABLE IF EXISTS [professional]
GO
CREATE TABLE [professional] (
    [professional_id] INTEGER IDENTITY NOT NULL,
    [professional_name] NVARCHAR(255) NOT NULL,
    CONSTRAINT [PK_professional] PRIMARY KEY ([professional_id])
)
GO
-------------------Hoang De----------------------
-------------------------------------------------
--create proc spGetAllProfessional--
IF EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME='spGetAllProfessional' AND TYPE ='P')
DROP PROC spGetAllProfessional
GO
create proc spGetAllProfessional
as
begin
select * from professional
end
go
-------------------------------------------
--create proc spInsertProfessional--
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
go
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
go
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
go
------------------------end-----






-----------------Achivement-----

--CREATE TABLE [doctor] (
 --   [doctor_id] INTEGER IDENTITY NOT NULL,
 --   [first_name] NVARCHAR(40) NOT NULL,
--	[last_name] NVARCHAR(40) NOT NULL,
--	[add_ress] NVARCHAR(50) NOT NULL,
--	[email] NVARCHAR(40) NOT NULL,
--	[phone_number] NVARCHAR(25) NOT NULL,
--	[birthday] smalldatetime NOT NULL,
--	[sex] NVARCHAR(6) NOT NULL,
--	[experience] INTEGER NOT NULL,
--	[city_id] INTEGER NOT NULL,
--	[qualification_id] INTEGER NOT NULL,
--	[professional_id] INTEGER NOT NULL,
 --   CONSTRAINT [PK_doctor] PRIMARY KEY ([doctor_id])
--)
--GO

--drop table achievement
--go
--CREATE TABLE [achievement] (
 --   [achievement_id] INTEGER IDENTITY NOT NULL,
  --  [desciption] NVARCHAR(255) NOT NULL,
	--[doctor_id] INTEGER NOT NULL,
   -- CONSTRAINT [PK_achievement] PRIMARY KEY ([achievement_id])
--)
---GO
-----------------------------------
--ALTER TABLE [achievement] ADD CONSTRAINT [doctor_achievement]
  --  FOREIGN KEY ([doctor_id]) REFERENCES [doctor] ([doctor_id])
---------------------------------

-----------------proc-----------------------------------
create proc spAllAchievement
as
begin
select * from achievement
end
go
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
go
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
go
-------------------------------------
CREATE PROC spGetAllDoctor
AS
SELECT * FROM doctor
GO
---------------------------------------