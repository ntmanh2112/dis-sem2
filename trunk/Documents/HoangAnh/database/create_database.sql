/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Project3.dez                                    */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2011-11-02 10:59                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "Doctors"                                                    */
/* ---------------------------------------------------------------------- */
create database doctor_information_system
go
use doctor_information_system
go
CREATE TABLE [Doctors] (
    [doctor_id] INTEGER IDENTITY(0,1) NOT NULL,
    [fisrt_name] VARCHAR(40),
    [last_name] VARCHAR(40),
    [add_ress] VARCHAR(50),
    [email] VARCHAR(40),
    [Professional_id] INTEGER NOT NULL,
    [Qualification_id] INTEGER NOT NULL,
    [City_id] INTEGER NOT NULL,
    [phone_number] VARCHAR(20),
    [birthday] SMALLDATETIME,
    [sex] VARCHAR(6),
    [experience] INTEGER,
    CONSTRAINT [PK_Doctors] PRIMARY KEY ([doctor_id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "History_doctor"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE [History_doctor] (
    [History_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [doctor_id] INTEGER NOT NULL,
    [from_date] SMALLDATETIME,
    [to_date] SMALLDATETIME,
    CONSTRAINT [PK_History_doctor] PRIMARY KEY ([History_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "user_login"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE [user_login] (
    [user_name] VARCHAR(40) NOT NULL,
    [pass_word] VARCHAR(20),
    [active] INTEGER,
    [role_id] INTEGER NOT NULL,
    CONSTRAINT [PK_user_login] PRIMARY KEY ([user_name])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Achievement"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Achievement] (
    [Achievement_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [doctor_id] INTEGER NOT NULL,
    [Description] VARCHAR(255),
    CONSTRAINT [PK_Achievement] PRIMARY KEY ([Achievement_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "City"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE [City] (
    [City_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [City_name] VARCHAR(40),
    [Country_ID] INTEGER NOT NULL,
    CONSTRAINT [PK_City] PRIMARY KEY ([City_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Country"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Country] (
    [Country_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [Country_name] VARCHAR(40),
    CONSTRAINT [PK_Country] PRIMARY KEY ([Country_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Qualification"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Qualification] (
    [Qualification_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [Qualification_name] VARCHAR(40),
    CONSTRAINT [PK_Qualification] PRIMARY KEY ([Qualification_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Professional"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Professional] (
    [Professional_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [Professional_name] VARCHAR(40),
    CONSTRAINT [PK_Professional] PRIMARY KEY ([Professional_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Role"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Role] (
    [role_id] INTEGER IDENTITY(0,1) NOT NULL,
    [role_name] VARCHAR(40),
    CONSTRAINT [PK_Role] PRIMARY KEY ([role_id])
)
GO

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE [Doctors] ADD CONSTRAINT [City_Doctors] 
    FOREIGN KEY ([City_id]) REFERENCES [City] ([City_ID])
GO

ALTER TABLE [Doctors] ADD CONSTRAINT [Qualification_Doctors] 
    FOREIGN KEY ([Qualification_id]) REFERENCES [Qualification] ([Qualification_ID])
GO

ALTER TABLE [Doctors] ADD CONSTRAINT [Professional_Doctors] 
    FOREIGN KEY ([Professional_id]) REFERENCES [Professional] ([Professional_ID])
GO

ALTER TABLE [History_doctor] ADD CONSTRAINT [Doctors_History_doctor] 
    FOREIGN KEY ([doctor_id]) REFERENCES [Doctors] ([doctor_id])
GO

ALTER TABLE [user_login] ADD CONSTRAINT [Role_user_login] 
    FOREIGN KEY ([role_id]) REFERENCES [Role] ([role_id])
GO

ALTER TABLE [Achievement] ADD CONSTRAINT [Doctors_Achievement] 
    FOREIGN KEY ([doctor_id]) REFERENCES [Doctors] ([doctor_id])
GO

ALTER TABLE [City] ADD CONSTRAINT [Country_City] 
    FOREIGN KEY ([Country_ID]) REFERENCES [Country] ([Country_ID])
GO
