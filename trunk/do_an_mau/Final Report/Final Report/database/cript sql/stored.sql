
--sp_DELETEMENUROLES.sql
/***********************************************************
* Purpose : DELETE MENUROLES
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: DELETE A MENUROLES TO dbo.sys_Menu_Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_MENUROLES' )
BEGIN
	DROP PROC sp_DELETE_MENUROLES
END
GO
CREATE PROC sp_DELETE_MENUROLES
	@rolesID	int,
	@menuID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM sys_Menu_Roles WHERE roles_ID = @rolesID AND menu_ID = @menuID)
	BEGIN
		DELETE sys_Menu_Roles 
		WHERE roles_ID = @rolesID AND menu_ID = @menuID
		SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_DELETE_ACCOUNTMANAGER.sql

/***********************************************************
* Purpose : DELETE ACCOUNT MANAGER
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE ACCOUNT MANAGER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_ACCOUNTMANAGER' )
BEGIN
	DROP PROC sp_DELETE_ACCOUNTMANAGER
END 
GO
CREATE PROC sp_DELETE_ACCOUNTMANAGER
	@acID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM AccountManager WHERE ac_ID = @acID AND ac_ID <> 0 )
	BEGIN
		DELETE AccountManager WHERE ac_ID = @acID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_DELETE_CATEGORY.sql
/***********************************************************
* Purpose : DELETE CATEGORY
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE CATEGORY
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_CATEGORY' ) 
BEGIN
	DROP  PROC sp_DELETE_CATEGORY
END
GO
CREATE PROC sp_DELETE_CATEGORY
	@catID int,
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM Category WHERE cat_ID = @catID)
		BEGIN
			DELETE Product 
			WHERE cat_ID = @catID
			DELETE Category
			WHERE cat_ID = @catID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END

GO

--sp_DELETE_CITY.sql
/***********************************************************
* Purpose : DELETE CITY
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE CITY
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_CITY' )
BEGIN
	DROP proc sp_DELETE_CITY
END 
GO
CREATE PROC sp_DELETE_CITY
	@cityID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM City WHERE city_ID = @cityID )
	BEGIN
		DELETE City WHERE city_ID = @cityID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_DELETE_COMPLAINT.sql
/***********************************************************
* Purpose : DELETE COMPLAINT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE COMPLAINT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_COMPLAINT' ) 
BEGIN
	DROP  PROC sp_DELETE_COMPLAINT
END
GO
CREATE PROC sp_DELETE_COMPLAINT
	@cplID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM Complaints WHERE cpl_ID = @cplID)
		BEGIN
			DELETE Complaints
			WHERE cpl_ID = @cplID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_DELETE_COMPLAINTSTYLE.sql
/***********************************************************
* Purpose : DELETE COMPLAINTSTYLE
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE COMPLAINTSTYLE
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_COMPLAINTSTYLE' )
BEGIN
	DROP PROC sp_DELETE_COMPLAINTSTYLE
END 
GO
CREATE PROC sp_DELETE_COMPLAINTSTYLE
	@cplstyID		int,
	@Result			int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM Complaint_Style WHERE cpl_sty_ID = @cplstyID )
	BEGIN
		DELETE Complaint_Style WHERE cpl_sty_ID = @cplstyID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_DELETE_CUSTOMER.sql
/***********************************************************
* Purpose : DELETE CUSTOMER
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE CUSTOMER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_CUSTOMER' ) 
BEGIN
	DROP  PROC sp_DELETE_CUSTOMER
END
GO
CREATE PROC sp_DELETE_CUSTOMER
	@cusID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM Customers WHERE cus_ID = @cusID)
	BEGIN
		DELETE Customers WHERE cus_ID = @cusID
		SET @Result = 1 
	END
	ELSE 
	BEGIN
		SET @Result = 0
	END
END
GO

--sp_DELETE_DETAILS.sql
/***********************************************************
* Purpose : DELETE ORDERDETAILS
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: DELETE A ORDERDETAILS TO dbo.sys_Menu_Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_ORDERDETAILS' )
BEGIN
	DROP PROC sp_DELETE_ORDERDETAILS
END
GO
CREATE PROC sp_DELETE_ORDERDETAILS
	@orID		int,
	@pdID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM OrderDetails WHERE or_ID = @orID AND pd_ID = @pdID)
	BEGIN
		DELETE OrderDetails 
		WHERE or_ID = @orID AND pd_ID = @pdID
		SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_DELETE_DISPATCH.sql
/***********************************************************
* Purpose : DELETE DISPATCH
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE DISPATCH
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_DISPATCH' ) 
BEGIN
	DROP  PROC sp_DELETE_DISPATCH
END
GO
CREATE PROC sp_DELETE_DISPATCH
	@dpID		int,
	@Result		int		OUTPUT
AS
BEGIN
IF EXISTS (SELECT * FROM Dispatch WHERE dp_ID = @dpID)
	BEGIN 
		DELETE Dispatch WHERE dp_ID = @dpID
		SET @Result = 1
	END
ELSE
	BEGIN
		SET @Result = 0
	END
END





GO

--sp_DELETE_DISTRICT.sql
/***********************************************************
* Purpose : DELETE DISTRICT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE DISTRICT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_DISTRICT' )
BEGIN
	DROP proc sp_DELETE_DISTRICT
END 
GO
CREATE PROC sp_DELETE_DISTRICT
	@dtrID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM District WHERE dtr_ID = @dtrID )
	BEGIN
		DELETE District WHERE dtr_ID = @dtrID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_DELETE_ORDERS.sql
/***********************************************************
* Purpose : DELETE ORDERS
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE ORDERS
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_ORDERS' ) 
BEGIN
	DROP  PROC sp_DELETE_ORDERS
END
GO
CREATE PROC sp_DELETE_ORDERS
	@orID		int,
	@Result		int OUTPUT
AS
BEGIN
IF EXISTS (SELECT * FROM Orders WHERE or_ID = @orID)
	BEGIN 
		DELETE Orders WHERE or_ID = @orID
		SET @Result = 1
	END
ELSE
	BEGIN
		SET @Result = 0
	END
END





GO

--sp_DELETE_PRODUCT.sql
/***********************************************************
* Purpose : DELETE PRODUCT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE PRODUCT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_PRODUCT' ) 
BEGIN
	DROP  PROC sp_DELETE_PRODUCT
END
GO
CREATE PROC sp_DELETE_PRODUCT
	@pdID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM Product WHERE pd_ID = @pdID)
		BEGIN
			DELETE Product
			WHERE pd_ID = @pdID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END

GO

--sp_DELETE_ROLES.sql
/***********************************************************
* Purpose : DELETE ROLES
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE A ROLES FROM dbo.Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_ROLES' )
BEGIN
	DROP PROC sp_DELETE_ROLES
END 
GO
CREATE PROC sp_DELETE_ROLES
	@rolesID	int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM Roles WHERE roles_ID = @rolesID )
	BEGIN
		DELETE Roles WHERE roles_ID = @rolesID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_DELETE_SYSMENU.sql
/***********************************************************
* Purpose : DELETE SYSMENU
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: DELETE A SYSMENU FROM dbo.sys_Menu
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_DELETE_SYSMENU' )
BEGIN
	DROP PROC sp_DELETE_SYSMENU
END 
GO
CREATE PROC sp_DELETE_SYSMENU
	@menuID int,
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM sys_Menu WHERE menu_ID = @MenuID )
	BEGIN
		DELETE sys_Menu WHERE menu_ID = @menuID
		SET @Result = 1 
	END 
	ELSE
	BEGIN
		SET @Result = 0 
	END 
END
GO

--sp_INSERT_ACCOUNTMANAGER.sql
/***********************************************************
* Purpose : INSERT ACCOUNTMANAGER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A ACCOUNT TO dbo.Category
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_ACCOUNTMANAGER' ) 
BEGIN
	DROP PROC sp_INSERT_ACCOUNTMANAGER
END
GO
CREATE PROC sp_INSERT_ACCOUNTMANAGER
	@acID			int,
	@RolesID		int,
	@acFirstname	nvarchar(40),
	@acMiddlename	nvarchar(40),
	@acLastName		nvarchar(40),
	@acUserName		nvarchar(40),
	@acPassword		nvarchar(40),
	@acDate			datetime,
	@acLastUpdate	datetime,
	@Result			int		OUTPUT 
AS 
BEGIN
	SELECT	@acLastUpdate = GETDATE()
	SELECT	@acDate = GETDATE()
	IF NOT EXISTS ( SELECT * FROM AccountManager WHERE ac_ID = @acID OR ac_UserName = @acUserName)
	BEGIN
		INSERT INTO AccountManager 
		VALUES (@RolesID,
				@acFirstname,
				@acMiddlename,
				@acLastName,
				@acUserName,
				@acPassword,	
				@acDate,	
				@acLastUpdate)
		SET @Result = 1 -- successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- failse
	END 
END 
GO

--sp_INSERT_CATEGORY.sql
/***********************************************************
* Purpose : INSERT CATEGORY
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A CATEGORY TO dbo.Category
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_CATEGORY' ) 
BEGIN
	DROP  PROC sp_INSERT_CATEGORY
END
GO
CREATE PROC sp_INSERT_CATEGORY
	@catID			int,
	@catName		nvarchar(50),
	@catDescription nvarchar(150),
	@catImage		nvarchar(200),
	@catLastUpdate	datetime,
	@Result			int OUTPUT
AS
BEGIN
SELECT @catLastUpdate= GETDATE()
IF  NOT EXISTS ( SELECT * FROM Category WHERE cat_ID = @catID OR cat_Name = @catName)
	BEGIN
		INSERT INTO Category
		VALUES (@catName,
				@catDescription,
				@catImage,
				@catLastUpdate)
		SET @Result = 1 --successfull
	END
ELSE
	BEGIN
		SET @Result = 0 -- failse
	END
END

	
GO

--sp_INSERT_CITY.sql
/***********************************************************
* Purpose : INSERT CITY
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A CITY TO dbo.City
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_CITY' ) 
BEGIN
	DROP PROC sp_INSERT_CITY
END
GO
CREATE PROC sp_INSERT_CITY
	@cityID			int,
	@cityName		nvarchar(40),
	@cityLastUpdate datetime,
	@Result			int		OUTPUT
AS
BEGIN
	SELECT @cityLastUpdate= GETDATE()
	IF NOT EXISTS (SELECT * FROM City WHERE city_ID = @cityID )
		BEGIN
			INSERT INTO City
			VALUES(	@cityName,
					@cityLastUpdate)
			SET @Result  = 1 -- successfull
		END
	ELSE
		BEGIN
			SET @Result =  0 -- failse
		END
END
				
GO

--sp_INSERT_COMPLAINT.sql

/***********************************************************
* Purpose : INSERT COMPLAINT
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A COMPLAINT TO boc.Complaint
*/

IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_COMPLAINT' ) 
BEGIN
	DROP  PROC sp_INSERT_COMPLAINT
END
GO
CREATE PROC sp_INSERT_COMPLAINT
	@cplID			int,
	@orID			int,
	@cplTittle		nvarchar(100),
	@cplContent		nvarchar(500),
	@cplDate		datetime,
	@cplstyID		int,
	@cplStatus		int,
	@cplLastUpdate	datetime,
	@rolesID			int,
	@Result			int		OUTPUT
	
AS
BEGIN
SELECT @cplDate= GETDATE()
SELECT @cplLastUpdate= GETDATE()
IF NOT EXISTS ( SELECT * FROM Complaint WHERE cpl_ID = @cplID )
	BEGIN
		INSERT INTO Complaint
		VALUES (@orID,
				@cplTittle,
				@cplContent,	
				@cplDate,	
				@cplstyID,
				@cplStatus,
				@cplLastUpdate,
				@rolesID)
		SET @Result = 1 -- successfull
	END
ELSE
	BEGIN
		SET @Result = 0 -- failse
	END
END


	




GO

--sp_INSERT_COMPLAINTSTYLE.sql
/***********************************************************
* Purpose : INSET COMPLAINT STYLE
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A COMPLAINTSTYLE TO dbo.Complaint_Style
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_COMPLAINTSTYLE' ) 
BEGIN
	DROP PROC sp_INSERT_COMPLAINTSTYLE
END
GO
CREATE PROC sp_INSERT_COMPLAINTSTYLE
	@clpstyID		int,
	@cplstyName		nvarchar(40),
	@Result			int		OUTPUT 
AS 
BEGIN
	IF NOT EXISTS ( SELECT * FROM Complaint_Style WHERE cpl_sty_ID = @clpstyID )
	BEGIN
		INSERT INTO Complaint_Style 
		VALUES (@CplStyName)
		SET @Result = 1 --successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 --failse
	END 
END 
GO

--sp_INSERT_CUSTOMER.sql

/***********************************************************
* Purpose : INSERT CUSTOMER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A CUSTOMER TO dbo.Customer
*/

IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_CUSTOMER' ) 
BEGIN
	DROP  PROC sp_INSERT_CUSTOMER
END
GO
CREATE PROC sp_INSERT_CUSTOMER
	@cusID			int,
	@cusCode		varchar(40),
	@cusFirstName	nvarchar(50),
	@cusMiddleName	nvarchar(50),
	@cusLastName	nvarchar(50),
	@cusAddress		nvarchar(100),
	@cusDtrID		int,
	@cusCityID		int,
	@cusPhone		int,
	@cusEmail		nvarchar(100),
	@cusLastUpdate	datetime,
	@Result			int		OUTPUT
AS
BEGIN
	DECLARE @code varchar(30),
	@VALUE varchar(10)
	SET @code = 'CUS' 
	SELECT @VALUE = MAX(cus_ID)+1 FROM Customer
	SELECT @cusCode = @code + @VALUE
	SELECT @cusLastUpdate= GETDATE()
	IF NOT EXISTS ( SELECT * FROM Customer WHERE cus_ID = @cusID )
	BEGIN
		INSERT INTO	Customer 
		VALUES ( 
			@cusCode,
			@cusFirstName, 
			@cusMiddleName, 
			@cusLastName,
			@cusAddress, 
			@cusDtrID, 
			@cusCityID, 
			@cusPhone, 
			@cusEmail, 
			@cusLastUpdate )
		SET @Result = 1 -- INSERT SUCCESS
	END
	ELSE 
	BEGIN
		SET @Result = 0 -- EXISTS CUSTOMER
	END
END


GO

--sp_INSERT_DISPATCH.sql
/***********************************************************
* Purpose : INSERT DISPATCH
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A DISPATCH TO dbo.Dispatch 
*/

IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_DISPATCH' ) 
BEGIN
	DROP PROC sp_INSERT_DISPATCH
END
GO
CREATE PROC sp_INSERT_DISPATCH
	@dpID			int,
	@orID			int,
	@dpStatus		int,
	@dpLastUpdate	datetime,
	@Result			int		OUTPUT
AS
BEGIN
	SELECT @dpLastUpdate = GETDATE()
	IF NOT EXISTS (SELECT * FROM Dispatch WHERE dp_ID = @dpID )
	BEGIN
		INSERT INTO Dispatch
		VALUES (@orID,
				@dpStatus,
				@dpLastUpdate)
		SET @Result = 1 -- Successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- failse
	END
END
GO

--sp_INSERT_DISTRICT.sql

/***********************************************************
* Purpose : INSERT DISTRICT
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A DISTRICT TO dbo.District
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_DISTRICT' ) 
BEGIN
	DROP PROC sp_INSERT_DISTRICT
END
GO
CREATE PROC sp_INSERT_DISTRICT
	@dtrID			int, 
	@dtrName		nvarchar(40),
	@dtrLastUpdate	datetime,
	@Result			int		OUTPUT
AS
BEGIN
	SELECT @dtrLastUpdate= GETDATE()
	IF EXISTS (SELECT * FROM District WHERE dtr_ID = @dtrID)
	BEGIN
		INSERT INTO District
		VALUES (@dtrName,
				@dtrLastUpdate)
		SET @Result = 1 --successfull
	END
	ELSE 
	BEGIN
		SET @Result = 0 --failse
	END
END
GO

--sp_INSERT_MENUROLES.sql
/***********************************************************
* Purpose : INSERT MENUROLES
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A MENUROLES TO dbo.sys_Menu_Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_MENUROLES' )
BEGIN
	DROP PROC sp_INSERT_MENUROLES
END
GO
CREATE PROC sp_INSERT_MENUROLES
	@rolesID	int,
	@menuID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM sys_Menu_Roles WHERE roles_ID = @rolesID AND menu_ID = @menuID)
	BEGIN
		INSERT INTO sys_Menu_Roles 
		VALUES (@rolesID,
				@menuID)
		SET @Result = 1 -- Successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- Failse
	END
END
GO

--sp_INSERT_ORDER.sql

/***********************************************************
* Purpose : INSERT ORDER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A ORDER TO dbo.Order
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_ORDER' ) 
BEGIN
	DROP  PROC sp_INSERT_ORDER
END
GO
CREATE PROC sp_INSERT_ORDER
	@orID			int,
	@orCode			varchar(40),
	@cusID			int,
	@orDate			datetime,
	@orStatus		int,
	@orLastUpdate	datetime, 
	@Result			int		OUTPUT
AS
BEGIN
	DECLARE @code varchar(30),
	@VALUE varchar(10)
	SET @code = 'HD' 
	SELECT @VALUE = MAX(or_ID)+1 FROM Orders
	SELECT @orCode = @code + @VALUE
	SELECT @orDate = GETDATE()
	SELECT @orLastUpdate = GETDATE()
	IF NOT EXISTS (SELECT * FROM Orders WHERE or_ID = @orID)
	BEGIN
		INSERT INTO Orders
		VALUES (@orCode,
				@cusID,
				@orDate,
				@orStatus,
				@orLastUpdate)
		SET @Result = 1 -- successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- failse
	END
END
GO

--SP_INSERT_ORDERDETAILS.sql
/***********************************************************
* Purpose : INSERT ORDERDETAILS
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A ORDERDETAILS
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_ORDERDETAILS' )
BEGIN
	DROP PROC sp_INSERT_ORDERDETAILS
END
GO
CREATE PROC sp_INSERT_ORDERDETAILS
	@orID		int,
	@pdID		int,
	@orQuanlity int,
	@LastUpdate datetime,
	@Result		int		OUTPUT
AS
BEGIN
	SELECT @LastUpdate = GETDATE()
	IF NOT EXISTS (SELECT * FROM OrderDetails WHERE or_ID = @orID AND pd_ID = @pdID)
	BEGIN
		INSERT INTO OrderDetails 
		VALUES (@orID,
				@pdID,
				@orQuanlity,
				@LastUpdate)
		SET @Result = 1 -- Successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- Failse
	END
END
GO

--sp_INSERT_PRODUCT.sql

/***********************************************************
* Purpose : INSERT PRODUCT 
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT PRODUCT TO dbo.Product
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_PRODUCT' ) 
BEGIN
	DROP  PROC sp_INSERT_PRODUCT
END
GO
CREATE PROC sp_INSERT_PRODUCT
	@pdID			int,
	@catID			int,
	@pdName			nvarchar(70), 
	@pdDescription	nvarchar(150),
	@pdPrice		numeric,
	@pdWarranty		varchar(40),
	@pdImage		nvarchar(200),
	@pdLastUpdate	datetime,
	@Result			int		OUTPUT
AS
BEGIN
	SELECT @pdLastUpdate= GETDATE()
	IF NOT EXISTS (SELECT * FROM Product WHERE pd_ID = @pdID)
		BEGIN
			INSERT INTO Product
			VALUES (@catID,
					@pdName,	
					@pdDescription,	
					@pdPrice,
					@pdWarranty,
					@pdImage,
					@pdLastUpdate)
			SET @Result = 1 -- successfull
		END
	ELSE
		BEGIN
			SET @Result = 0 -- failse
		END
END
	
GO

--sp_INSERT_ROLES.sql

/***********************************************************
* Purpose : INSERT ROLES
* Author : PhuongTQ
* Date: 09-10-2010
* Description: INSERT A ROLE TO bod.Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_ROLES' ) 
BEGIN
	DROP PROC sp_INSERT_ROLES
END
GO
CREATE PROC sp_INSERT_ROLES
	@rolesID			int,
	@rolesName			nvarchar(40),
	@rolesLastUpdate	datetime,
	@Result				int		OUTPUT 
AS 
BEGIN
	SELECT @rolesLastUpdate= GETDATE()
	IF NOT EXISTS ( SELECT * FROM Role WHERE roles_ID =  @rolesID)
	BEGIN
		INSERT INTO Roles
		VALUES (@rolesName,
				@rolesLastUpdate)
		SET @Result = 1 -- successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 --failse
	END 
END 
GO

--sp_INSERT_SYSMENU.sql
/***********************************************************
* Purpose : INSERT SYSMENU
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: INSERT A SYSMENU TO dbo.sys_Menu
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_INSERT_SYSMENU' ) 
BEGIN
	DROP PROC sp_INSERT_SYSMENU
END
GO
CREATE PROC sp_INSERT_SYSMENU
	@menuID				int,
	@menuName			nvarchar(40),
	@menuLastUpdate		datetime,
	@Result				int		OUTPUT 
AS 
BEGIN
	SELECT @menuLastUpdate = GETDATE()
	IF NOT EXISTS ( SELECT * FROM sys_Menu WHERE menu_ID =  @menuID)
	BEGIN
		INSERT INTO sys_Menu 
		VALUES (@menuName,
				@menuLastUpdate)
		SET @Result = 1 -- Successfull
	END
	ELSE
	BEGIN
		SET @Result = 0 -- Failse
	END 
END 
GO

--sp_SEARCH_ACCOUNTMANAGER.sql
/***********************************************************
* Purpose : SEARCH ACCOUNTMANAGER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH ACCOUNTMANAGER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_ACCOUNTMANAGER' )
BEGIN
	DROP PROC sp_SEARCH_ACCOUNTMANAGER
END
GO
CREATE PROC sp_SEARCH_ACCOUNTMANAGER
	@userName nvarchar(40),
	@fullName nvarchar(120)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_ACCOUNTMANAGER')
	BEGIN
		DROP TABLE SEARCH_ACCOUNTMANAGER		
	END
	CREATE TABLE SEARCH_ACCOUNTMANAGER
	(
			ac_ID			INT,
			roles_Name		TEXT,
			FullName		TEXT,
			ac_UserName		TEXT,
			ac_Password		TEXT,
			ac_Date			DATETIME
	)
	--OPTION 1 :BASED ON USERNAME
	IF @userName <> '' AND @fullName = ''
	BEGIN
		INSERT INTO SEARCH_ACCOUNTMANAGER
		SELECT 
			A.ac_ID,
			B.roles_Name,
			A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname AS 'FullName',
			A.ac_UserName,
			A.ac_Password,
			A.ac_Date
		FROM AccountManager AS A
		INNER JOIN Roles AS B
		ON A.roles_ID = B.roles_ID
		WHERE A.ac_UserName LIKE + '%'+@userName+'%'
	END
	--OPTION 2 :BASED ON FULLNAME
	ELSE IF @userName = '' AND @fullName <> ''
		 BEGIN
			INSERT INTO SEARCH_ACCOUNTMANAGER
			SELECT 
				A.ac_ID,
				B.roles_Name,
				A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname AS 'FullName',
				A.ac_UserName,
				A.ac_Password,
				A.ac_Date
			FROM AccountManager AS A
			INNER JOIN Roles AS B
			ON A.roles_ID = B.roles_ID
			WHERE A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname LIKE '%'+@fullName+'%'
		END
		--OPTION 3 :BASED ON FULLNAME AND USERNAME
		ELSE IF @userName <> '' AND @fullName <> ''
			 BEGIN
				INSERT INTO SEARCH_ACCOUNTMANAGER
				SELECT 
					A.ac_ID,
					B.roles_Name,
					A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname AS 'FullName',
					A.ac_UserName,
					A.ac_Password,
					A.ac_Date
				FROM AccountManager AS A
				INNER JOIN Roles AS B
				ON A.roles_ID = B.roles_ID
				WHERE A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname LIKE '%'+@fullName+'%'
			    AND A.ac_UserName LIKE + '%'+@userName+'%'		  			 
			 END
			 --OPTION 4 :SEATCH ALL
			 ELSE IF @userName = '' AND @fullName = ''
				  BEGIN
					 INSERT INTO SEARCH_ACCOUNTMANAGER
					 SELECT 
				   		A.ac_ID,
						B.roles_Name,
						A.ac_Firstname+' '+A.ac_Middlename+' '+A.ac_Lastname AS 'FullName',
						A.ac_UserName,
						A.ac_Password,
						A.ac_Date
					 FROM AccountManager AS A
					 INNER JOIN Roles AS B
					 ON A.roles_ID = B.roles_ID			 
				  END
END
GO

--sp_SEARCH_CATEGORY.sql
/***********************************************************
* Purpose : SEARCH CATEGORY
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH CATEGORY
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_CATEGORY' )
BEGIN
	DROP PROC sp_SEARCH_CATEGORY
END
GO
CREATE PROC sp_SEARCH_CATEGORY
	@categoryName nvarchar(50)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_CATEGORY')
	BEGIN
		DROP TABLE SEARCH_CATEGORY		
	END
	CREATE TABLE SEARCH_CATEGORY
	(
		cat_ID				INT,
		cat_Name			TEXT,
		cat_Description		TEXT,
		cat_Image			TEXT,
		cat_Last_Update		DATETIME
	)
	IF @categoryName = ''
	BEGIN
		INSERT SEARCH_CATEGORY
		SELECT  * 
		FROM Category
	END
	ELSE IF @categoryName <> ''
			BEGIN
				INSERT SEARCH_CATEGORY
				SELECT * 
				FROM Category 
				WHERE cat_Name LIKE  '%'+@categoryName+'%'
			END
END
GO

--sp_SEARCH_COMPLAINT.sql
/***********************************************************
* Purpose : SEARCH COMPLAINT
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH COMPLAINT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_COMPLAINT' )
BEGIN
	DROP PROC sp_SEARCH_COMPLAINT
END
GO
CREATE PROC sp_SEARCH_COMPLAINT
	@customerName	nvarchar(70),
	@status			varchar(10)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_COMPLAINT')
	BEGIN
		DROP TABLE SEARCH_COMPLAINT		
	END
	CREATE TABLE SEARCH_COMPLAINT
	(
			cpl_ID			INT,
			CustomerName	TEXT,
			or_Code			TEXT,
			cus_Phone		TEXT,
			cus_Email		TEXT,
			cpl_Tittle		TEXT,
			cpl_Content		TEXT,
			cpl_Date		DATETIME,
			cpl_sty_Name	TEXT,
			cpl_Status		INT,
			roles_Name		TEXT 
	)
	--OPTION 1 : BASED ON CUSTOMER NAME
	IF @customerName <> '' AND @status = ''
	BEGIN
		INSERT INTO SEARCH_COMPLAINT
		SELECT
			A.cpl_ID,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'CustomerName',
			B.or_Code,
			C.cus_Phone,
			C.cus_Email,
			A.cpl_Tittle,
			A.cpl_Content,
			A.cpl_Date,
			D.cpl_sty_Name,
			A.cpl_Status,
			F.roles_Name 		
		FROM Complaint AS A
		INNER JOIN Orders AS B
		ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C
		ON B.cus_ID = C.cus_ID
		INNER JOIN Complaint_Style AS D
		ON A.cpl_sty_ID = D.cpl_sty_ID
		INNER JOIN Roles AS F
		ON A.roles_ID = F.roles_ID
		WHERE C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname LIKE '%'+ @customerName+'%'
	END
	
	--OPTION 2 : BASED ON STATUS
	ELSE IF @customerName = '' AND @status <> ''
		 BEGIN
			INSERT INTO SEARCH_COMPLAINT
			SELECT
				A.cpl_ID,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'CustomerName',
				B.or_Code,
				C.cus_Phone,
				C.cus_Email,
				A.cpl_Tittle,
				A.cpl_Content,
				A.cpl_Date,
				D.cpl_sty_Name,
				A.cpl_Status,
				F.roles_Name 			
			FROM Complaint AS A
			INNER JOIN Orders AS B
			ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C
			ON B.cus_ID = C.cus_ID
			INNER JOIN Complaint_Style AS D
			ON A.cpl_sty_ID = D.cpl_sty_ID
			INNER JOIN Roles AS F
			ON A.roles_ID = F.roles_ID
			WHERE CAST(A.cpl_Status AS varchar(10)) = @status
		END
		--OPTION 3 : BASED ON STATUS AND CUSTOMER
		ELSE IF @customerName <> '' AND @status <> ''
			 BEGIN
				INSERT INTO SEARCH_COMPLAINT
				SELECT
					A.cpl_ID,
					C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'CustomerName',
					B.or_Code,
					C.cus_Phone,
					C.cus_Email,
					A.cpl_Tittle,
					A.cpl_Content,
					A.cpl_Date,
					D.cpl_sty_Name,
					A.cpl_Status,
					F.roles_Name				
				FROM Complaint AS A
				INNER JOIN Orders AS B
				ON A.or_ID = B.or_ID
				INNER JOIN Customer AS C
				ON B.cus_ID = C.cus_ID
				INNER JOIN Complaint_Style AS D
				ON A.cpl_sty_ID = D.cpl_sty_ID
				INNER JOIN Roles AS F
				ON A.roles_ID = F.roles_ID
				WHERE CAST (A.cpl_Status AS varchar (10)) = @status
				AND C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname LIKE '%'+ @customerName+'%'
			 END
			 --OPTION 4 : SEARCH ALL
			 ELSE IF @customerName = '' AND @status = ''
				  BEGIN	
					  INSERT INTO SEARCH_COMPLAINT
					  SELECT
						A.cpl_ID,
						C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'CustomerName',
						B.or_Code,
						C.cus_Phone,
						C.cus_Email,
						A.cpl_Tittle,
						A.cpl_Content,
						A.cpl_Date,
						D.cpl_sty_Name,
						A.cpl_Status,
						F.roles_Name					  
					  FROM Complaint AS A
					  INNER JOIN Orders AS B
					  ON A.or_ID = B.or_ID
					  INNER JOIN Customer AS C
					  ON B.cus_ID = C.cus_ID
					  INNER JOIN Complaint_Style AS D
					  ON A.cpl_sty_ID = D.cpl_sty_ID
					  INNER JOIN Roles AS F
					  ON A.roles_ID = F.roles_ID
				  END
			  
	--SELECT * FROM SEARCH_COMPLAINT
END
GO

--sp_SEARCH_CUSTOMER.sql
/***********************************************************
* Purpose : SEARCH CUSTOMER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH CUSTOMER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_CUSTOMER' )
BEGIN
	DROP PROC sp_SEARCH_CUSTOMER
END
GO
CREATE PROC sp_SEARCH_CUSTOMER
	@customerName	nvarchar(150),
	@districtID		nvarchar(40),
	@cityID			nvarchar(40)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_CUSTOMER')
	BEGIN
		DROP TABLE SEARCH_CUSTOMER		
	END
	CREATE TABLE SEARCH_CUSTOMER
	(
			cus_ID			INT,
			CustomerName	TEXT,
			cus_Code		TEXT,
			cus_Address		TEXT,
			dtr_Name		TEXT,
			city_Name		TEXT,
			cus_Phone		INT,
			cus_Email		TEXT
	)
	-- OPTION 1  : BASED ON CUSTOMER NAME
	IF @customerName <>'' AND @districtID = '' AND @cityID = ''
	BEGIN
		INSERT INTO SEARCH_CUSTOMER
		SELECT
			A.cus_ID,
			A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
			A.cus_Code,
			A.cus_Address,
			B.dtr_Name,
			C.city_Name,
			A.cus_Phone,
			A.cus_Email
		FROM Customer AS A
		INNER JOIN District AS B 
		ON A.cus_dtr_ID = B.dtr_ID
		INNER JOIN City AS C
		ON A.cus_city_ID = C.city_ID
		WHERE A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname LIKE '%'+@customerName+'%'
	END
	-- OPTION 2  : BASED ON DISTRICT 	
	ELSE IF @customerName = '' AND @districtID <> '' AND @cityID = ''
		 BEGIN
		 INSERT INTO SEARCH_CUSTOMER
		 SELECT
			A.cus_ID,
			A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
			A.cus_Code,
			A.cus_Address,
			B.dtr_Name,
			C.city_Name,
			A.cus_Phone,
			A.cus_Email
		 FROM Customer AS A
		 INNER JOIN District AS B 
		 ON A.cus_dtr_ID = B.dtr_ID
		 INNER JOIN City AS C
		 ON A.cus_city_ID = C.city_ID
		 WHERE B.dtr_ID LIKE @districtID
		 END
			  -- OPTION 3  : BASED ON CITY 	
		 ELSE IF @customerName = '' AND @districtID = '' AND @cityID <> ''
			  BEGIN
			  INSERT INTO SEARCH_CUSTOMER
			  SELECT
				 A.cus_ID,
				 A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
				 A.cus_Code,
				 A.cus_Address,
				 B.dtr_Name,
				 C.city_Name,
				 A.cus_Phone,
				 A.cus_Email
			  FROM Customer AS A
			  INNER JOIN District AS B 
			  ON A.cus_dtr_ID = B.dtr_ID
			  INNER JOIN City AS C
			  ON A.cus_city_ID = C.city_ID
			  WHERE C.city_ID LIKE @cityID
			  END
			  -- OPTION 4  : BASED ON CUSTOMER AND DISTRICT 	
			  ELSE IF @customerName <> '' AND @districtID <> '' AND @cityID = ''
				   BEGIN
				   INSERT INTO SEARCH_CUSTOMER
				   SELECT
					   A.cus_ID,
					   A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
					   A.cus_Code,
					   A.cus_Address,
					   B.dtr_Name,
					   C.city_Name,
					   A.cus_Phone,
					   A.cus_Email
				   FROM Customer AS A
				   INNER JOIN District AS B 
				   ON A.cus_dtr_ID = B.dtr_ID
				   INNER JOIN City AS C
				   ON A.cus_city_ID = C.city_ID
				   WHERE A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname LIKE '%'+@customerName+'%'
				   AND B.dtr_ID LIKE @districtID
				   END
				   -- OPTION 5  : BASED ON CUSTOMER AND CITY 
				   ELSE IF @customerName <> '' AND @districtID = '' AND @cityID <> ''
						BEGIN
						INSERT INTO SEARCH_CUSTOMER
						SELECT
						    A.cus_ID,
						    A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
						    A.cus_Code,
						    A.cus_Address,
						    B.dtr_Name,
						    C.city_Name,
						    A.cus_Phone,
						    A.cus_Email
					    FROM Customer AS A
					    INNER JOIN District AS B 
					    ON A.cus_dtr_ID = B.dtr_ID
					    INNER JOIN City AS C
					    ON A.cus_city_ID = C.city_ID
					    WHERE A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname LIKE '%'+@customerName+'%'
					    AND C.city_ID LIKE @cityID
						END
						-- OPTION 6  : BASED ON DISTRICT AND CITY 
						ELSE IF @customerName = '' AND @districtID <> '' AND @cityID <> ''
							 BEGIN
							 INSERT INTO SEARCH_CUSTOMER
							 SELECT
								 A.cus_ID,
								 A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
								 A.cus_Code,
								 A.cus_Address,
								 B.dtr_Name,
								 C.city_Name,
								 A.cus_Phone,
								 A.cus_Email
							 FROM Customer AS A
							 INNER JOIN District AS B 
							 ON A.cus_dtr_ID = B.dtr_ID
							 INNER JOIN City AS C
							 ON A.cus_city_ID = C.city_ID
							 WHERE B.dtr_ID LIKE @districtID
							 AND C.city_ID LIKE @cityID
							 END
							 -- OPTION 7  : BASED ON DISTRICT AND CITY AND CUSTOMER
							 ELSE IF @customerName <> '' AND @districtID <> '' AND @cityID <> ''
								  BEGIN
								  INSERT INTO SEARCH_CUSTOMER
								  SELECT
									  A.cus_ID,
									  A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
									  A.cus_Code,
									  A.cus_Address,
									  B.dtr_Name,
									  C.city_Name,
									  A.cus_Phone,
									  A.cus_Email
								  FROM Customer AS A
								  INNER JOIN District AS B 
								  ON A.cus_dtr_ID = B.dtr_ID
								  INNER JOIN City AS C
								  ON A.cus_city_ID = C.city_ID
								  WHERE A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname LIKE '%'+@customerName+'%'
								  AND B.dtr_ID LIKE @districtID
								  AND C.city_ID LIKE @cityID
								  END
								  -- OPTION 8  : SEARCH ALL
								  ELSE IF @customerName = '' AND @districtID = '' AND @cityID = ''
								  BEGIN
								  INSERT INTO SEARCH_CUSTOMER
								  SELECT
									  A.cus_ID,
									  A.cus_Fristname+' '+A.cus_Middlename+' '+A.cus_Lastname AS 'CustomerName',
									  A.cus_Code,
									  A.cus_Address,
									  B.dtr_Name,
									  C.city_Name,
									  A.cus_Phone,
									  A.cus_Email
								  FROM Customer AS A
								  INNER JOIN District AS B 
								  ON A.cus_dtr_ID = B.dtr_ID
								  INNER JOIN City AS C
								  ON A.cus_city_ID = C.city_ID
								  END
END 
GO

--sp_SEARCH_ORDER.sql
/***********************************************************
* Purpose : SEARCH ORDER
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH ORDER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_ORDER' )
BEGIN
	DROP PROC sp_SEARCH_ORDER
END
GO
CREATE PROC sp_SEARCH_ORDER
	@customerName	NVARCHAR(150),
	@phone			VARCHAR(50),
	@statusOrder	VARCHAR(10),	
	@statusDispatch VARCHAR(10)	
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_ORDER')
	BEGIN
		DROP TABLE SEARCH_ORDER		
	END
	CREATE TABLE SEARCH_ORDER
	(
			or_ID				INT,
			or_Code				TEXT,
			customerName		TEXT,
			cus_Phone			INT,
			cus_Email			TEXT,
			customerAddress		TEXT,
			or_Date				DATETIME,
			or_Status			INT,
			dp_Status			INT
	)
	IF @customerName = '' AND @phone = '' AND @statusOrder = '' AND @statusDispatch = '' 
		BEGIN
			-- DIEU KIEN 1 ==> SEARCH ALL
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
		END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone <> '' AND @statusOrder <> '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 2 ==> SEARCH CUSTOMER NAME + PHONE + ORDER + DISPATCH 
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
			WHERE  C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
			AND C.cus_Phone LIKE '%' + @phone + '%'
			AND CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
			AND CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch
		END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone = '' AND @statusOrder = '' AND @statusDispatch = ''
		BEGIN
			-- DIEU KIEN 3 ==> SEARCH CUSTOMER NAME
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE  C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
		END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone <> '' AND @statusOrder = '' AND @statusDispatch = ''
	BEGIN
		-- DIEU KIEN 4 ==> SEARCH PHONE
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID 
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
		WHERE  C.cus_Phone LIKE '%' + @phone + '%'
	END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone = '' AND @statusOrder <> '' AND @statusDispatch = ''
	BEGIN
		-- DIEU KIEN 5 ==> SEARCH STATUS ORDER
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
		WHERE CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
	END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone = '' AND @statusOrder = '' AND @statusDispatch <> ''
	BEGIN
		-- DIEU KIEN 5 ==> SEARCH STATUS DISPATCH
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
		WHERE CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch
	END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone <> '' AND @statusOrder = '' AND @statusDispatch = ''
	BEGIN
		-- DIEU KIEN 6 ==> SEARCH PHONE AND CUSTOMERNAME
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID 
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID
		WHERE C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
		AND C.cus_Phone LIKE '%' + @phone + '%'
	END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone = '' AND @statusOrder <> '' AND @statusDispatch = ''
	BEGIN
		-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS ORDER
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
		WHERE  C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
		AND  CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
	END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone = '' AND @statusOrder = '' AND @statusDispatch <> ''
	BEGIN
		-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS DISPATCH
		INSERT SEARCH_ORDER
		SELECT 
			B.or_ID,
			B.or_Code,
			C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
			C.cus_Phone,
			C.cus_Email,
			C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
			B.or_Date,
			B.or_Status,
			A.dp_Status
		FROM Dispatch AS A
		INNER JOIN Orders AS B ON A.or_ID = B.or_ID
		INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
		INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
		INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
		WHERE  C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
		AND  CAST(A.dp_Status AS VARCHAR(10)) = @statusOrder
	END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone <> '' AND @statusOrder <> '' AND @statusDispatch = ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE  C.cus_Phone LIKE '%' + @phone + '%'
			AND  CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
		END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone <> '' AND @statusOrder = '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE  C.cus_Phone LIKE '%' + @phone + '%'
			AND CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch		
		END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone = '' AND @statusOrder <> '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE  CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
			AND CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch		
		END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone <> '' AND @statusOrder <> '' AND @statusDispatch = ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE  CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
			AND C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
			AND	C.cus_Phone LIKE '%' + @phone + '%'	
		END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone <> '' AND @statusOrder = '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch
			AND C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
			AND	C.cus_Phone LIKE '%' + @phone + '%'	
		END
	---------------	
	---------------
	ELSE IF @customerName <> '' AND @phone = '' AND @statusOrder <> '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
			AND C.cus_Fristname + ' ' + C.cus_Middlename + ' ' + C.cus_Lastname LIKE '%' + @customerName + '%'
			AND	CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch
		END
	---------------	
	---------------
	ELSE IF @customerName = '' AND @phone <> '' AND @statusOrder <> '' AND @statusDispatch <> ''
		BEGIN
			-- DIEU KIEN 7 ==> SEARCH CUSTOMER NAME + STATUS
			INSERT SEARCH_ORDER
			SELECT 
				B.or_ID,
				B.or_Code,
				C.cus_Fristname+' '+C.cus_Middlename+' '+C.cus_Lastname AS 'customerName',
				C.cus_Phone,
				C.cus_Email,
				C.cus_Address+' , '+D.dtr_Name+' , '+E.city_Name AS 'customerAddress',
				B.or_Date,
				B.or_Status,
				A.dp_Status
			FROM Dispatch AS A
			INNER JOIN Orders AS B ON A.or_ID = B.or_ID
			INNER JOIN Customer AS C ON B.cus_ID = C.cus_ID
			INNER JOIN District AS D ON C.cus_dtr_ID = D.dtr_ID
			INNER JOIN City AS E ON  C.cus_city_ID = E.city_ID 
			WHERE CAST(B.or_Status AS VARCHAR(10)) = @statusOrder
			AND C.cus_Phone LIKE '%' + @phone + '%'	
			AND	CAST(A.dp_Status AS VARCHAR(10)) = @statusDispatch
		END
END
GO

--sp_SEARCH_PRODUCT.sql
/***********************************************************
* Purpose : SEARCH PRODUCT
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: SEARCH PRODUCT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_SEARCH_PRODUCT' )
BEGIN
	DROP PROC sp_SEARCH_PRODUCT
END
GO
CREATE PROC sp_SEARCH_PRODUCT
	@productName	nvarchar(70),
	@categoryID	nvarchar(50)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.sysobjects WHERE name='SEARCH_PRODUCT')
	BEGIN
		DROP TABLE SEARCH_PRODUCT		
	END
	CREATE TABLE SEARCH_PRODUCT
	(
			pd_ID				INT,
			cat_Name			TEXT,
			pd_Name				TEXT,
			pd_DesCription		TEXT,
			pd_Price			INT,
			pd_Warranty			TEXT,
			pd_Image			TEXT
	)
	-- OPTION 1 : BASED ON PRODUCT NAME
	IF @productName <> '' AND @categoryID = ''
	BEGIN
		INSERT SEARCH_PRODUCT
		SELECT
			A.pd_ID,
			B.cat_Name,
			A.pd_Name,
			A.pd_DesCription,
			A.pd_Price,
			A.pd_Warranty,
			A.pd_Image
		FROM Product AS A
		INNER JOIN Category AS B
		ON A.cat_ID = B.cat_ID
		WHERE A.pd_Name LIKE '%'+@productName+'%'
	END
	-- OPTION 2 : BASED ON CATEGORY NAME
	ELSE IF @productName = '' AND @categoryID <> ''
		 BEGIN
			INSERT SEARCH_PRODUCT
			SELECT
				A.pd_ID,
				B.cat_Name,
				A.pd_Name,
				A.pd_DesCription,
				A.pd_Price,
				A.pd_Warranty,
				A.pd_Image
			FROM Product AS A
			INNER JOIN Category AS B
			ON A.cat_ID = B.cat_ID
			WHERE B.cat_ID = @categoryID
		 END
		 -- OPTION 3 : SEARCH ALL
		 ELSE IF @productName = '' AND @categoryID = ''
			  BEGIN
					INSERT SEARCH_PRODUCT
					SELECT
						A.pd_ID,
						B.cat_Name,
						A.pd_Name,
						A.pd_DesCription,
						A.pd_Price,
						A.pd_Warranty,
						A.pd_Image
					FROM Product AS A
					INNER JOIN Category AS B
					ON A.cat_ID = B.cat_ID	
			  END
			  -- OPTION 4 : BASED ON PRODUCT NAME AND CATEGORY NAME
			  ELSE IF @productName <> '' AND @categoryID <> ''
				   BEGIN
						INSERT SEARCH_PRODUCT
						SELECT
							A.pd_ID,
							B.cat_Name,
							A.pd_Name,
							A.pd_DesCription,
							A.pd_Price,
							A.pd_Warranty,
							A.pd_Image
						FROM Product AS A
						INNER JOIN Category AS B
						ON A.cat_ID = B.cat_ID
						WHERE B.cat_ID = @categoryID
						AND A.pd_Name LIKE '%'+@productName+'%'
				   END
END
GO

--sp_UPDATE_ACCOUNTMANAGER.sql
/***********************************************************
* Purpose : UPDATE ACCOUNT MANAGER
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE ACCOUNT MANAGER
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_ACCOUNTMANAGER' ) 
BEGIN
	DROP PROC sp_UPDATE_ACCOUNTMANAGER
END
GO
CREATE PROC sp_UPDATE_ACCOUNTMANAGER
	@acID int,
	@RolesID int,
	@acFirstname nvarchar(40),
	@acMiddlename nvarchar(40),
	@acLastName nvarchar(40),
	@acUserName nvarchar(40),
	@acPassword nvarchar(40),
	@acLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @acLastUpdate = GETDATE()
	IF EXISTS ( SELECT * FROM AccountManager WHERE ac_ID = @acID )
	BEGIN
		UPDATE AccountManager
		SET	roles_ID = @RolesID,
			ac_FirstName = @acFirstname,
			ac_MiddleName = @acMiddlename,
			ac_LastName = @acLastName,
			ac_UserName = @acUserName,
			ac_Password = @acPassword,
			ac_Last_Update = @acLastUpdate
		WHERE ac_ID = @acID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END 
GO

--sp_UPDATE_CATEGORY.sql
/***********************************************************
* Purpose : UPDATE CATEGOOTY
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE CATEGORY
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_CATEGORY' )
BEGIN
	DROP PROC sp_UPDATE_CATEGORY
END 
GO
CREATE PROC sp_UPDATE_CATEGORY
	@catID int,
	@catName nvarchar(50),
	@catDescription nvarchar(150),
	@catImage nvarchar(200),
	@catLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @catLastUpdate = GETDATE()
	IF EXISTS ( SELECT * FROM Category WHERE cat_ID = @catID )
		BEGIN
			UPDATE	Category
			    SET cat_Name = @catName,
					cat_Description = @catDescription,
					cat_Image = @catImage,
					cat_Last_Update = @catLastUpdate
			WHERE 
				cat_ID = @catID
			SET @Result = 1
		END 
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_UPDATE_CITY.sql
/***********************************************************
* Purpose : UPDATE CITY
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE CITY
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_CITY' ) 
BEGIN
	DROP PROC sp_UPDATE_CITY
END
GO
CREATE PROC sp_UPDATE_CITY
	@cityID int,
	@cityName nvarchar (40),	
	@cityLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM City WHERE city_ID = @cityID )
	BEGIN
		UPDATE City
		SET	
			city_Name = @cityName,
			city_Last_Update = @cityLastUpdate
		
		WHERE city_ID = @cityID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END 
GO

--sp_UPDATE_COMPLAINT.sql
/***********************************************************
* Purpose : UPDATE COMPLAINT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE COMPLAINT
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_COMPLAINT' )
BEGIN
	DROP PROC sp_UPDATE_COMPLAINT
END 
GO
CREATE PROC sp_UPDATE_COMPLAINT
	@cplID int,
	@cplStatus int,
	@cplLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @cplLastUpdate = GETDATE()
	IF EXISTS (SELECT * FROM Complaint WHERE cpl_ID = @cplID)
		BEGIN
			UPDATE Complaint
			SET 
				cpl_Status = @cplStatus,
				cpl_Last_Update = @cplLastUpdate
			WHERE cpl_ID = @cplID
			SET @Result = 1
		END
	ELSE 
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_UPDATE_COMPLAINTSTYLE.sql
/***********************************************************
* Purpose : UPDATE COMPLAINT STYLE
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE COMPLAINT STYLE
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_COMPLAINTSTYLE' ) 
BEGIN
	DROP PROC sp_UPDATE_COMPLAINTSTYLE
END
GO
CREATE PROC sp_UPDATE_COMPLAINTSTYLE
	@cplstyID int,
	@cplstyName varchar(40),
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM Complaint_Style WHERE cpl_sty_ID = @cplstyID )
		BEGIN
			UPDATE Complaint_Style
			SET	cpl_sty_Name=@cplstyName
			WHERE cpl_sty_ID = @cplstyID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END 
GO

--sp_UPDATE_CUSTOMER.sql
/***********************************************************
* Purpose : UPDATE CUSTOMER
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE CUSTOMER
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_CUSTOMER' )
BEGIN
	DROP PROC sp_UPDATE_CUSTOMER
END 
GO
CREATE PROC sp_UPDATE_CUSTOMER
	@cusID int,
	@cusFirstName nvarchar(50),
	@cusMiddleName nvarchar(50),
	@cusLastName nvarchar(50),
	@cusAddress nvarchar(100),
	@cusDtrID int,
	@cusCityID int,
	@cusPhone int,
	@cusEmail nvarchar(100),
	@cusLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @CusLastUpdate = GETDATE()
	
	IF EXISTS ( SELECT * FROM Customer WHERE cus_ID = @cusID )
	BEGIN
		UPDATE Customer
		SET cus_Fristname = @cusFirstName ,
			cus_Middlename = @cusMiddleName,
			cus_Lastname = @cusLastName,
			cus_Address = @cusAddress,
			cus_dtr_ID = @cusDtrID,
			cus_city_ID = @cusCityID,
			cus_Phone = @cusPhone,
			cus_Email = @cusEmail,
			cus_Last_Update = @cusLastUpdate
		WHERE
			cus_ID = @cusID
		SET  @Result = 1
	END 
	ELSE 
	BEGIN
		SET  @Result = 0
	END 
END
GO

--sp_UPDATE_DISPATCH.sql
/***********************************************************
* Purpose : UPDATE DISPATCH
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE DISPATCH
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_DISPATCH' )
BEGIN
	DROP PROC sp_UPDATE_DISPATCH
END 
GO
CREATE PROC sp_UPDATE_DISPATCH
	@dpID int,
	@dpStatus int,
	@dpLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @dpLastUpdate = GETDATE()
	IF EXISTS ( SELECT * FROM Dispatch WHERE dp_ID = @dpID)
	BEGIN
		UPDATE Dispatch
		SET
			dp_Status = @dpStatus,
			dp_Last_Update = @dpLastUpdate 
		WHERE
			dp_ID = @dpID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END
GO

--sp_UPDATE_DISTRICT.sql
/***********************************************************
* Purpose : UPDATE DISTRICT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE DISTRICT
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_DISTRICT' ) 
BEGIN
	DROP PROC sp_UPDATE_DISTRICT
END
GO
CREATE PROC sp_UPDATE_DISTRICT
	@dtrID int,
	@dtrName nvarchar (40),	
	@dtrLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM District WHERE dtr_ID = @dtrID )
	BEGIN
		UPDATE District
		SET	
			dtr_Name = @dtrName,
			dtr_Last_Update = @dtrLastUpdate
		
		WHERE dtr_ID = @dtrID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END 
GO

--sp_UPDATE_MENUROLES.sql
/***********************************************************
* Purpose : UPDATE MENUROLES
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: UPDATE A MENUROLES TO dbo.sys_Menu_Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_MENUROLES' )
BEGIN
	DROP PROC sp_UPDATE_MENUROLES
END
GO
CREATE PROC sp_UPDATE_MENUROLES
	@rolesID	int,
	@menuID		int,
	@Result		int		OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM sys_Menu_Roles WHERE roles_ID = @rolesID AND menu_ID = @menuID)
		BEGIN
			UPDATE sys_Menu_Roles
			SET
				roles_ID = @rolesID,
				menu_ID = @menuID
			WHERE 
				roles_ID = @rolesID 
				AND menu_ID = @menuID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_UPDATE_ORDERDETAILS.sql
/***********************************************************
* Purpose : UPDATE MENUROLES
* Author : Nguyen Chi Tam
* Date: 09-10-2010
* Description: UPDATE A MENUROLES TO dbo.sys_Menu_Roles
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_ORDERDETAILS' )
BEGIN
	DROP PROC sp_UPDATE_ORDERDETAILS
END
GO
CREATE PROC sp_UPDATE_ORDERDETAILS
	@orID		int,
	@pdID		int,
	@orQuanlity int,
	@LastUpdate datetime,
	@Result		int		OUTPUT
AS
BEGIN
	SELECT @LastUpdate = GETDATE()
	IF EXISTS (SELECT * FROM OrderDetails WHERE or_ID = @orID AND pd_ID = @pdID)
		BEGIN
			UPDATE OrderDetails
			SET
				or_Quality = @orQuanlity,
				or_dt_Last_Update = @LastUpdate
			WHERE or_ID = @orID
			AND	pd_ID = @pdID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
GO

--sp_UPDATE_ORDERS.sql
/***********************************************************
* Purpose : UPDATE ORDERS
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE ORDERS
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_ORDERS' )
BEGIN
	DROP PROC sp_UPDATE_ORDERS
END 
GO
CREATE PROC sp_UPDATE_ORDERS
	@orID int,
	@orStatus int,
	@orLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @orLastUpdate = GETDATE()
	IF EXISTS ( SELECT * FROM Orders WHERE or_ID = @orID)
	BEGIN
		UPDATE Orders
		SET
			or_Status = @orStatus,
			or_Last_Update = @orLastUpdate
		WHERE
			or_ID = @orID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END

GO

--sp_UPDATE_PRODUCT.sql
/***********************************************************
* Purpose : UPDATE PRODUCT
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE PRODUCT
*/
IF EXISTS ( SELECT * FROM dbo.sysobjects WHERE NAME= 'sp_UPDATE_PRODUCT' )
BEGIN
	DROP PROC sp_UPDATE_PRODUCT
END 
GO
CREATE PROC sp_UPDATE_PRODUCT
	@pdID int,
	@catID int,
	@pdName nvarchar(70),
	@pdDescription nvarchar(150),
	@pdPrice numeric,
	@pdWarranty nvarchar(40),
	@pdImage nvarchar(200),
	@pdLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	SELECT @pdLastUpdate = GETDATE()
	IF EXISTS ( SELECT * FROM Product WHERE pd_ID = @pdID )
		BEGIN
			UPDATE Product
			SET cat_ID = @catID,
				pd_Name = @pdName,
				pd_Description = @pdDescription,
				pd_Price = @pdPrice,
				pd_Warranty = @pdWarranty,
				pd_Image = @pdImage,
				pd_Last_Update = @pdLastUpdate
				
			WHERE 
				pd_ID = @pdID
			SET @Result = 1
		END
	ELSE
		BEGIN
			SET @Result = 0
		END
END
				
GO

--sp_UPDATE_ROLES.sql
/***********************************************************
* Purpose : UPDATE ROLES
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE ROLES
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_ROLES' ) 
BEGIN
	DROP PROC sp_UPDATE_ROLES
END
GO
CREATE PROC sp_UPDATE_ROLES
	@rolesID int,
	@rolesName nvarchar(40),
	@rolesLastUpdate datetime,
	@Result int OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM Roles WHERE roles_ID = @rolesID )
	BEGIN
		UPDATE Roles
		SET	roles_Name = @rolesName,
			roles_Last_Update = @rolesLastUpdate
		WHERE roles_ID = @rolesID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END 
GO

--sp_UPDATE_SYSMENU.sql
/***********************************************************
* Purpose : UPDATE SYSMENU
* Author : TU CHI DUNG
* Date: 09-10-2010
* Description: UPDATE SYSMENU
*/
IF EXISTS ( SELECT * FROM SYSOBJECTS WHERE NAME = 'sp_UPDATE_SYSMENU' ) 
BEGIN
	DROP PROC sp_UPDATE_SYSMENU
END
GO
CREATE PROC sp_UPDATE_SYSMENU
	@menuID			int,
	@menuname		nvarchar(40),
	@menuLastUpdate datetime,
	@Result			int		OUTPUT
AS
BEGIN
	IF EXISTS ( SELECT * FROM sys_Menu WHERE menu_ID = @menuID )
	BEGIN
		UPDATE sys_Menu
		SET	menu_Name = @menuname,
			menu_Last_Update = @menuLastUpdate
		WHERE menu_ID = @menuID
		SET @Result = 1
	END
	ELSE
	BEGIN
		SET @Result = 0
	END
END 
GO
