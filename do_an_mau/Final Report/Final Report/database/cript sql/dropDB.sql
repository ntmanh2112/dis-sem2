/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Bang csdl.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2010-10-22 10:31                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

ALTER TABLE [Complaint] DROP CONSTRAINT [Orders_Complaint]
GO

ALTER TABLE [Complaint] DROP CONSTRAINT [Complaint_Style_Complaint]
GO

ALTER TABLE [Complaint] DROP CONSTRAINT [Roles_Complaint]
GO

ALTER TABLE [Customer] DROP CONSTRAINT [District_Customer]
GO

ALTER TABLE [Customer] DROP CONSTRAINT [City_Customer]
GO

ALTER TABLE [Orders] DROP CONSTRAINT [Customer_Orders]
GO

ALTER TABLE [Dispatch] DROP CONSTRAINT [Orders_Dispatch]
GO

ALTER TABLE [Product] DROP CONSTRAINT [Category_Product]
GO

ALTER TABLE [AccountManager] DROP CONSTRAINT [Roles_AccountManager]
GO

ALTER TABLE [sys_Menu_Roles] DROP CONSTRAINT [Roles_sys_Menu_Roles]
GO

ALTER TABLE [sys_Menu_Roles] DROP CONSTRAINT [sys_Menu_sys_Menu_Roles]
GO

ALTER TABLE [OrderDetails] DROP CONSTRAINT [Product_OrderDetails]
GO

ALTER TABLE [OrderDetails] DROP CONSTRAINT [Orders_OrderDetails]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Complaint"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Complaint] DROP CONSTRAINT [PK_Complaint]
GO

/* Drop table */

DROP TABLE [Complaint]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Customer"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Customer] DROP CONSTRAINT [PK_Customer]
GO

/* Drop table */

DROP TABLE [Customer]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Orders"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Orders] DROP CONSTRAINT [PK_Orders]
GO

/* Drop table */

DROP TABLE [Orders]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Dispatch"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Dispatch] DROP CONSTRAINT [PK_Dispatch]
GO

/* Drop table */

DROP TABLE [Dispatch]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Product"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Product] DROP CONSTRAINT [PK_Product]
GO

/* Drop table */

DROP TABLE [Product]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Category"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Category] DROP CONSTRAINT [PK_Category]
GO

/* Drop table */

DROP TABLE [Category]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "AccountManager"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [AccountManager] DROP CONSTRAINT [PK_AccountManager]
GO

/* Drop table */

DROP TABLE [AccountManager]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Roles"                                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Roles] DROP CONSTRAINT [PK_Roles]
GO

/* Drop table */

DROP TABLE [Roles]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "sys_Menu"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [sys_Menu] DROP CONSTRAINT [PK_sys_Menu]
GO

/* Drop table */

DROP TABLE [sys_Menu]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "sys_Menu_Roles"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [sys_Menu_Roles] DROP CONSTRAINT [PK_sys_Menu_Roles]
GO

/* Drop table */

DROP TABLE [sys_Menu_Roles]
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
/* Drop table "District"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [District] DROP CONSTRAINT [PK_District]
GO

/* Drop table */

DROP TABLE [District]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "Complaint_Style"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [Complaint_Style] DROP CONSTRAINT [PK_Complaint_Style]
GO

/* Drop table */

DROP TABLE [Complaint_Style]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "OrderDetails"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [OrderDetails] DROP CONSTRAINT [PK_OrderDetails]
GO

/* Drop table */

DROP TABLE [OrderDetails]
GO
