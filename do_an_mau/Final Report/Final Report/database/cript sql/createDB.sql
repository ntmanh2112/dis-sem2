/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Bang csdl.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2010-10-22 10:31                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "Complaint"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Complaint] (
    [cpl_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [or_ID] INTEGER NOT NULL,
    [cpl_Tittle] NVARCHAR(100),
    [cpl_Content] NVARCHAR(500),
    [cpl_Date] DATETIME,
    [cpl_sty_ID] INTEGER NOT NULL,
    [cpl_Status] INTEGER,
    [cpl_Last_Update] DATETIME,
    [roles_ID] INTEGER NOT NULL,
    CONSTRAINT [PK_Complaint] PRIMARY KEY ([cpl_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Customer"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Customer] (
    [cus_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [cus_Code] VARCHAR(40),
    [cus_Fristname] NVARCHAR(50),
    [cus_Middlename] NVARCHAR(50),
    [cus_Lastname] NVARCHAR(50),
    [cus_Address] NVARCHAR(100),
    [cus_dtr_ID] INTEGER,
    [cus_city_ID] INTEGER,
    [cus_Phone] VARCHAR(50),
    [cus_Email] NVARCHAR(100),
    [cus_Last_Update] DATETIME,
    CONSTRAINT [PK_Customer] PRIMARY KEY ([cus_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Orders"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Orders] (
    [or_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [or_Code] VARCHAR(40),
    [cus_ID] INTEGER NOT NULL,
    [or_Date] DATETIME,
    [or_Status] INTEGER,
    [or_Last_Update] DATETIME,
    CONSTRAINT [PK_Orders] PRIMARY KEY ([or_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Dispatch"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Dispatch] (
    [dp_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [or_ID] INTEGER NOT NULL,
    [dp_Status] INTEGER,
    [dp_Last_Update] DATETIME,
    CONSTRAINT [PK_Dispatch] PRIMARY KEY ([dp_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Product"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Product] (
    [pd_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [cat_ID] INTEGER NOT NULL,
    [pd_Name] NVARCHAR(70),
    [pd_Description] NVARCHAR(150),
    [pd_Price] NUMERIC,
    [pd_Warranty] NVARCHAR(40),
    [pd_Image] NVARCHAR(200),
    [pd_Last_Update] DATETIME,
    CONSTRAINT [PK_Product] PRIMARY KEY ([pd_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Category"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Category] (
    [cat_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [cat_Name] NVARCHAR(50),
    [cat_Description] NVARCHAR(150),
    [cat_Image] NVARCHAR(200),
    [cat_Last_Update] DATETIME,
    CONSTRAINT [PK_Category] PRIMARY KEY ([cat_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "AccountManager"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE [AccountManager] (
    [ac_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [roles_ID] INTEGER NOT NULL,
    [ac_Firstname] NVARCHAR(40),
    [ac_Middlename] NVARCHAR(40),
    [ac_Lastname] NVARCHAR(40),
    [ac_UserName] NVARCHAR(40),
    [ac_Password] NVARCHAR(40),
    [ac_Date] DATETIME,
    [ac_Last_Update] DATETIME,
    CONSTRAINT [PK_AccountManager] PRIMARY KEY ([ac_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Roles"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Roles] (
    [roles_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [roles_Name] NVARCHAR(40),
    [roles_Last_Update] DATETIME,
    CONSTRAINT [PK_Roles] PRIMARY KEY ([roles_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "sys_Menu"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [sys_Menu] (
    [menu_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [menu_Name] NVARCHAR(40),
    [menu_Last_Update] DATETIME,
    CONSTRAINT [PK_sys_Menu] PRIMARY KEY ([menu_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "sys_Menu_Roles"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE [sys_Menu_Roles] (
    [roles_ID] INTEGER NOT NULL,
    [menu_ID] INTEGER NOT NULL,
    CONSTRAINT [PK_sys_Menu_Roles] PRIMARY KEY ([roles_ID], [menu_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "City"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE [City] (
    [city_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [city_Name] NVARCHAR(40),
    [city_Last_Update] DATETIME,
    CONSTRAINT [PK_City] PRIMARY KEY ([city_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "District"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [District] (
    [dtr_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [dtr_Name] NVARCHAR(40),
    [dtr_Last_Update] DATETIME,
    CONSTRAINT [PK_District] PRIMARY KEY ([dtr_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Complaint_Style"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Complaint_Style] (
    [cpl_sty_ID] INTEGER IDENTITY(0,1) NOT NULL,
    [cpl_sty_Name] VARCHAR(40),
    CONSTRAINT [PK_Complaint_Style] PRIMARY KEY ([cpl_sty_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "OrderDetails"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE [OrderDetails] (
    [or_ID] INTEGER NOT NULL,
    [pd_ID] INTEGER NOT NULL,
    [or_Quality] INTEGER,
    [or_dt_Last_Update] DATETIME,
    CONSTRAINT [PK_OrderDetails] PRIMARY KEY ([or_ID], [pd_ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE [Complaint] ADD CONSTRAINT [Orders_Complaint] 
    FOREIGN KEY ([or_ID]) REFERENCES [Orders] ([or_ID])
GO

ALTER TABLE [Complaint] ADD CONSTRAINT [Complaint_Style_Complaint] 
    FOREIGN KEY ([cpl_sty_ID]) REFERENCES [Complaint_Style] ([cpl_sty_ID])
GO

ALTER TABLE [Complaint] ADD CONSTRAINT [Roles_Complaint] 
    FOREIGN KEY ([roles_ID]) REFERENCES [Roles] ([roles_ID])
GO

ALTER TABLE [Customer] ADD CONSTRAINT [District_Customer] 
    FOREIGN KEY ([cus_dtr_ID]) REFERENCES [District] ([dtr_ID])
GO

ALTER TABLE [Customer] ADD CONSTRAINT [City_Customer] 
    FOREIGN KEY ([cus_city_ID]) REFERENCES [City] ([city_ID])
GO

ALTER TABLE [Orders] ADD CONSTRAINT [Customer_Orders] 
    FOREIGN KEY ([cus_ID]) REFERENCES [Customer] ([cus_ID])
GO

ALTER TABLE [Dispatch] ADD CONSTRAINT [Orders_Dispatch] 
    FOREIGN KEY ([or_ID]) REFERENCES [Orders] ([or_ID])
GO

ALTER TABLE [Product] ADD CONSTRAINT [Category_Product] 
    FOREIGN KEY ([cat_ID]) REFERENCES [Category] ([cat_ID])
GO

ALTER TABLE [AccountManager] ADD CONSTRAINT [Roles_AccountManager] 
    FOREIGN KEY ([roles_ID]) REFERENCES [Roles] ([roles_ID])
GO

ALTER TABLE [sys_Menu_Roles] ADD CONSTRAINT [Roles_sys_Menu_Roles] 
    FOREIGN KEY ([roles_ID]) REFERENCES [Roles] ([roles_ID])
GO

ALTER TABLE [sys_Menu_Roles] ADD CONSTRAINT [sys_Menu_sys_Menu_Roles] 
    FOREIGN KEY ([menu_ID]) REFERENCES [sys_Menu] ([menu_ID])
GO

ALTER TABLE [OrderDetails] ADD CONSTRAINT [Product_OrderDetails] 
    FOREIGN KEY ([pd_ID]) REFERENCES [Product] ([pd_ID])
GO

ALTER TABLE [OrderDetails] ADD CONSTRAINT [Orders_OrderDetails] 
    FOREIGN KEY ([or_ID]) REFERENCES [Orders] ([or_ID])
GO
