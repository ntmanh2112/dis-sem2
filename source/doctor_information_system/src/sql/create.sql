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
SELECT N'Jakarta',4 UNION ALL 
SELECT N'Phnom Penh',3
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