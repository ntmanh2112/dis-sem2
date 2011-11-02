/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Project3.dez                                    */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2011-11-02 10:59                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

ALTER TABLE [Doctors] DROP CONSTRAINT [City_Doctors]
GO

ALTER TABLE [Doctors] DROP CONSTRAINT [Qualification_Doctors]
GO

ALTER TABLE [Doctors] DROP CONSTRAINT [Professional_Doctors]
GO

ALTER TABLE [History_doctor] DROP CONSTRAINT [Doctors_History_doctor]
GO

ALTER TABLE [user_login] DROP CONSTRAINT [Role_user_login]
GO

ALTER TABLE [Achievement] DROP CONSTRAINT [Doctors_Achievement]
GO

ALTER TABLE [City] DROP CONSTRAINT [Country_City]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Doctors"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Doctors] DROP CONSTRAINT [PK_Doctors]
GO

/* Drop table */

DROP TABLE [Doctors]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "History_doctor"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [History_doctor] DROP CONSTRAINT [PK_History_doctor]
GO

/* Drop table */

DROP TABLE [History_doctor]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "user_login"                                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [user_login] DROP CONSTRAINT [PK_user_login]
GO

/* Drop table */

DROP TABLE [user_login]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Achievement"                                               */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Achievement] DROP CONSTRAINT [PK_Achievement]
GO

/* Drop table */

DROP TABLE [Achievement]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "City"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [City] DROP CONSTRAINT [PK_City]
GO

/* Drop table */

DROP TABLE [City]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Country"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Country] DROP CONSTRAINT [PK_Country]
GO

/* Drop table */

DROP TABLE [Country]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Qualification"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Qualification] DROP CONSTRAINT [PK_Qualification]
GO

/* Drop table */

DROP TABLE [Qualification]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Professional"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Professional] DROP CONSTRAINT [PK_Professional]
GO

/* Drop table */

DROP TABLE [Professional]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Role"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Role] DROP CONSTRAINT [PK_Role]
GO

/* Drop table */

DROP TABLE [Role]
GO
