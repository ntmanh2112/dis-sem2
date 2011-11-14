------INSERT CATEGORY

INSERT INTO Category VALUES ('Moblie','not Description','',GETDATE())

INSERT INTO Category VALUES ('Laptop','not Description','',GETDATE())

INSERT INTO Category VALUES ('PC','not Description','',GETDATE())

INSERT INTO Category VALUES ('Lanline','not Description','',GETDATE())

INSERT INTO Category VALUES ('MP3','not Description','',GETDATE())

--SELECT * FROM Category

------INSERT PRODUCT

INSERT INTO Product VALUES (0,'E72','not Description',300,'12 months','',GETDATE())

INSERT INTO Product VALUES (0,'N98','not Description',200,'12 months','',GETDATE())

INSERT INTO Product VALUES (1,'Inspiron','not Description',1000,'24 months','',GETDATE())

INSERT INTO Product VALUES (1,'Vostro','not Description',1100,'24 months','',GETDATE())

INSERT INTO Product VALUES (2,'IBM','not Description',400,'12 months','',GETDATE())

INSERT INTO Product VALUES (2,'INTEL','not Description',500,'12 months','',GETDATE())

INSERT INTO Product VALUES (3,'Viettell','not Description',100,'12 months','',GETDATE())

INSERT INTO Product VALUES (3,'EVN','not Description',120,'12 months','',GETDATE())

INSERT INTO Product VALUES (4,'Sony','not Description',200,'12 months','',GETDATE())

INSERT INTO Product VALUES (4,'Kingmax','not Description',70,'12 months','',GETDATE())

--SELECT * FROM Product

------INSERT COMPLAINT STYLE

INSERT INTO Complaint_Style VALUES ('Warranty')

INSERT INTO Complaint_Style VALUES ('Fault Product')

INSERT INTO Complaint_Style VALUES ('Price')

INSERT INTO Complaint_Style VALUES ('Order')

INSERT INTO Complaint_Style VALUES ('Employee')

--SELECT * FROM Complaint_Style

------INSERT DISTRICT

INSERT INTO District VALUES ('District 1',GETDATE())

INSERT INTO District VALUES ('District 2',GETDATE())

INSERT INTO District VALUES ('District 3',GETDATE())

INSERT INTO District VALUES ('District 4',GETDATE())

INSERT INTO District VALUES ('District 5',GETDATE())

INSERT INTO District VALUES ('District 6',GETDATE())

INSERT INTO District VALUES ('District 7',GETDATE())

INSERT INTO District VALUES ('District 8',GETDATE())

INSERT INTO District VALUES ('District 9',GETDATE())

INSERT INTO District VALUES ('District 10',GETDATE())

INSERT INTO District VALUES ('District 11',GETDATE())

INSERT INTO District VALUES ('District 12',GETDATE())

--SELECT * FROM District

------INSERT CITY

INSERT INTO City VALUES ('Ho Chi Minh',GETDATE())

INSERT INTO City VALUES ('Ha Noi',GETDATE())

INSERT INTO City VALUES ('Da Nang',GETDATE())

INSERT INTO City VALUES ('Can Tho',GETDATE())

INSERT INTO City VALUES ('Ben Tre',GETDATE())

INSERT INTO City VALUES ('Vinh Long',GETDATE())

INSERT INTO City VALUES ('Quang Nam',GETDATE())

INSERT INTO City VALUES ('Quan Ngai',GETDATE())

INSERT INTO City VALUES ('Lam Dong',GETDATE())

INSERT INTO City VALUES ('An Giang',GETDATE())

INSERT INTO City VALUES ('Tien Giang',GETDATE())

INSERT INTO City VALUES ('Thai Binh',GETDATE())

INSERT INTO City VALUES ('Ninh Binh',GETDATE())

INSERT INTO City VALUES ('Lang Son',GETDATE())

--SELECT * FROM City

------INSERT CUSTOMER

INSERT INTO Customer VALUES ('CUS000','Nguyen','Chi','Tam','23 Tran Hung Dao',0,1,0975767576,'tuchidung1989@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS001','Tu','Chi','Dung','12 Phu My Hung',2,13,0975587553,'nguyenchitam.0205@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS002','Nguyen','Van Tu','Son','10 Nguyen Trai',11,12,0977777888,'nguyenvants@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS003','Nguyen','Van','Nuoi','154 3thang2',9,9,0976757898,'nguyenvannuoi@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS004','Tran','Anh','Tuan','45 Truong Son',5,4,0971117222,'tuanta@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS005','Pham','Lan','Huong','51 Dien Bien Phu',7,12,0970907080,'huongpl@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS006','Nguyen','Tuan','An','98 Pham Hung',2,6,0973457678,'tuanan@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS007','Tran','Anh','Dai','67 Nguyen Kim',6,11,0971237098,'trananhdai@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS008','Nguyen','Van','Tho','111 Hau Giang',8,10,0971987657,'thonv@gmail.com',GETDATE())

INSERT INTO Customer VALUES ('CUS009','Tran','Chi','Cuong','192 Dong Tay',10,5,0972136789,'chicuong@gmail.com',GETDATE())

--SELECT * FROM Customer

------INSERT ORDERS

INSERT INTO Orders VALUES ('HD000',0,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD001',1,GETDATE(),0,GETDATE())

INSERT INTO Orders VALUES ('HD002',2,GETDATE(),0,GETDATE())

INSERT INTO Orders VALUES ('HD003',3,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD004',4,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD005',5,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD006',6,GETDATE(),0,GETDATE())

INSERT INTO Orders VALUES ('HD007',7,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD008',8,GETDATE(),1,GETDATE())

INSERT INTO Orders VALUES ('HD009',9,GETDATE(),0,GETDATE())

--SELECT * FROM Orders

------INSERT DISPATCH

INSERT INTO Dispatch VALUES (0,0,GETDATE())

INSERT INTO Dispatch VALUES (1,1,GETDATE())

INSERT INTO Dispatch VALUES (2,1,GETDATE())

INSERT INTO Dispatch VALUES (3,1,GETDATE())

INSERT INTO Dispatch VALUES (4,0,GETDATE())

INSERT INTO Dispatch VALUES (5,1,GETDATE())

INSERT INTO Dispatch VALUES (6,0,GETDATE())

INSERT INTO Dispatch VALUES (7,0,GETDATE())

INSERT INTO Dispatch VALUES (8,1,GETDATE())

INSERT INTO Dispatch VALUES (9,0,GETDATE())

--SELECT * FROM Dispatch

------INSERT SYS_MENU

INSERT INTO sys_Menu VALUES ('Login',GETDATE())

INSERT INTO sys_Menu VALUES ('Logout',GETDATE())

INSERT INTO sys_Menu VALUES ('Add Account Manager',GETDATE())

INSERT INTO sys_Menu VALUES ('Add Category',GETDATE())

INSERT INTO sys_Menu VALUES ('Add Complaint',GETDATE())

INSERT INTO sys_Menu VALUES ('Add Order',GETDATE())

INSERT INTO sys_Menu VALUES ('Add Product',GETDATE())

INSERT INTO sys_Menu VALUES ('Details Of Complaint',GETDATE())

INSERT INTO sys_Menu VALUES ('Details Of Customer',GETDATE())

INSERT INTO sys_Menu VALUES ('Details Of Product',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Account Manager',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Category',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Customer',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Dispatch',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Order',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Product',GETDATE())

INSERT INTO sys_Menu VALUES ('Update Status Complaint',GETDATE())

INSERT INTO sys_Menu VALUES ('Delete Account Manager',GETDATE())

INSERT INTO sys_Menu VALUES ('Delete Category',GETDATE())

INSERT INTO sys_Menu VALUES ('Delete Product',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Category',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Product',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Customer',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Complaint',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Order',GETDATE())

INSERT INTO sys_Menu VALUES ('Search Account Manager',GETDATE())

INSERT INTO sys_Menu VALUES ('Paid/Unpaid',GETDATE())

--SELECT * FROM sys_Menu

------INSERT ROLES

INSERT INTO Roles VALUES ('Admin',GETDATE())

INSERT INTO Roles VALUES ('Call Center',GETDATE())

INSERT INTO Roles VALUES ('Dispatch Manager',GETDATE())

INSERT INTO Roles VALUES ('Order Manager',GETDATE())

INSERT INTO Roles VALUES ('Product Manager',GETDATE())

INSERT INTO Roles VALUES ('Technical',GETDATE())

--SELECT * FROM Roles

------INSERT SYS_MENU_ROLES
--1.ADMIN
INSERT INTO sys_Menu_Roles VALUES (0,0)

INSERT INTO sys_Menu_Roles VALUES (0,1)

INSERT INTO sys_Menu_Roles VALUES (0,20)

INSERT INTO sys_Menu_Roles VALUES (0,9)

INSERT INTO sys_Menu_Roles VALUES (0,21)

INSERT INTO sys_Menu_Roles VALUES (0,8)

INSERT INTO sys_Menu_Roles VALUES (0,22)

INSERT INTO sys_Menu_Roles VALUES (0,7)

INSERT INTO sys_Menu_Roles VALUES (0,23)

INSERT INTO sys_Menu_Roles VALUES (0,24)

INSERT INTO sys_Menu_Roles VALUES (0,26)

INSERT INTO sys_Menu_Roles VALUES (0,2)

INSERT INTO sys_Menu_Roles VALUES (0,10)

INSERT INTO sys_Menu_Roles VALUES (0,17)

INSERT INTO sys_Menu_Roles VALUES (0,25)

--2.CALL CENTER

INSERT INTO sys_Menu_Roles VALUES (1,0)

INSERT INTO sys_Menu_Roles VALUES (1,1)

INSERT INTO sys_Menu_Roles VALUES (1,8)

INSERT INTO sys_Menu_Roles VALUES (1,22)

INSERT INTO sys_Menu_Roles VALUES (1,24)

INSERT INTO sys_Menu_Roles VALUES (1,26)

INSERT INTO sys_Menu_Roles VALUES (1,4)

INSERT INTO sys_Menu_Roles VALUES (1,16)

INSERT INTO sys_Menu_Roles VALUES (1,7)

INSERT INTO sys_Menu_Roles VALUES (1,23)

--4.DISPATCH MANAGER

INSERT INTO sys_Menu_Roles VALUES (2,0)

INSERT INTO sys_Menu_Roles VALUES (2,1)

INSERT INTO sys_Menu_Roles VALUES (2,13)

INSERT INTO sys_Menu_Roles VALUES (2,24)

INSERT INTO sys_Menu_Roles VALUES (2,26)

INSERT INTO sys_Menu_Roles VALUES (2,8)

INSERT INTO sys_Menu_Roles VALUES (2,22)

--5.ORDER MANAGER

INSERT INTO sys_Menu_Roles VALUES (3,0)

INSERT INTO sys_Menu_Roles VALUES (3,1)

INSERT INTO sys_Menu_Roles VALUES (3,5)

INSERT INTO sys_Menu_Roles VALUES (3,14)

INSERT INTO sys_Menu_Roles VALUES (3,24)

INSERT INTO sys_Menu_Roles VALUES (3,26)

INSERT INTO sys_Menu_Roles VALUES (3,8)

INSERT INTO sys_Menu_Roles VALUES (3,22)

INSERT INTO sys_Menu_Roles VALUES (3,12)

--6.PRODUCT MANAGER

INSERT INTO sys_Menu_Roles VALUES (4,0)

INSERT INTO sys_Menu_Roles VALUES (4,1)

INSERT INTO sys_Menu_Roles VALUES (4,4)

INSERT INTO sys_Menu_Roles VALUES (4,11)

INSERT INTO sys_Menu_Roles VALUES (4,18)

INSERT INTO sys_Menu_Roles VALUES (4,20)

INSERT INTO sys_Menu_Roles VALUES (4,6)

INSERT INTO sys_Menu_Roles VALUES (4,15)

INSERT INTO sys_Menu_Roles VALUES (4,19)

INSERT INTO sys_Menu_Roles VALUES (4,9)

INSERT INTO sys_Menu_Roles VALUES (4,21)

--7.TECHNICAL

INSERT INTO sys_Menu_Roles VALUES (5,0)

INSERT INTO sys_Menu_Roles VALUES (5,1)

INSERT INTO sys_Menu_Roles VALUES (5,16)

INSERT INTO sys_Menu_Roles VALUES (5,7)

INSERT INTO sys_Menu_Roles VALUES (5,23)

------INSERT ACCOUNT MANAGER

INSERT INTO AccountManager VALUES (0,'Nguyen','Chi','Tam','admin','admin',GETDATE(),GETDATE())

INSERT INTO AccountManager VALUES (1,'Tu','Chi','Dung','call','call',GETDATE(),GETDATE())

INSERT INTO AccountManager VALUES (2,'Nguyen','Van','Nuoi','dispatch','dispatch',GETDATE(),GETDATE())

INSERT INTO AccountManager VALUES (3,'Nguyen','Trong','Nghia','order','order',GETDATE(),GETDATE())

INSERT INTO AccountManager VALUES (4,'Tran','Anh','Tuan','product','product',GETDATE(),GETDATE())

INSERT INTO AccountManager VALUES (5,'Pham','Lan','Huong','tech','tech',GETDATE(),GETDATE())

--SELECT * FROM AccountManager

------INSERT COMPLAINT

INSERT INTO Complaint VALUES (0,'Help','Can you help me ?',GETDATE(),0,0,GETDATE(),1)

INSERT INTO Complaint VALUES (1,'Help 2','Can you help me ?',GETDATE(),1,0,GETDATE(),5)

INSERT INTO Complaint VALUES (2,'Help 3','Can you help me ?',GETDATE(),2,0,GETDATE(),1)

INSERT INTO Complaint VALUES (3,'Help 4','Can you help me ?',GETDATE(),3,1,GETDATE(),5)

INSERT INTO Complaint VALUES (4,'Help 5','Can you help me ?',GETDATE(),4,1,GETDATE(),1)

INSERT INTO Complaint VALUES (5,'Help 6','Can you help me ?',GETDATE(),0,0,GETDATE(),1)

INSERT INTO Complaint VALUES (6,'Help 7','Can you help me ?',GETDATE(),1,1,GETDATE(),5)

INSERT INTO Complaint VALUES (7,'Help 8','Can you help me ?',GETDATE(),2,0,GETDATE(),1)

INSERT INTO Complaint VALUES (8,'Help 9','Can you help me ?',GETDATE(),3,1,GETDATE(),5)

INSERT INTO Complaint VALUES (9,'Help 10','Can you help me ?',GETDATE(),4,1,GETDATE(),5)

--SELECT * FROM Complaint

--------INSERT ORDER DETAILS 

INSERT INTO OrderDetails VALUES (0,0,12,GETDATE())

INSERT INTO OrderDetails VALUES (0,1,23,GETDATE())

INSERT INTO OrderDetails VALUES (1,2,4,GETDATE())

INSERT INTO OrderDetails VALUES (1,8,10,GETDATE())

INSERT INTO OrderDetails VALUES (2,9,5,GETDATE())

INSERT INTO OrderDetails VALUES (2,5,7,GETDATE())

INSERT INTO OrderDetails VALUES (3,7,20,GETDATE())

INSERT INTO OrderDetails VALUES (3,8,11,GETDATE())

INSERT INTO OrderDetails VALUES (4,3,13,GETDATE())

INSERT INTO OrderDetails VALUES (4,6,9,GETDATE())

INSERT INTO OrderDetails VALUES (5,2,17,GETDATE())

INSERT INTO OrderDetails VALUES (5,7,14,GETDATE())

INSERT INTO OrderDetails VALUES (6,1,19,GETDATE())

INSERT INTO OrderDetails VALUES (6,8,25,GETDATE())

INSERT INTO OrderDetails VALUES (7,5,10,GETDATE())

INSERT INTO OrderDetails VALUES (7,9,14,GETDATE())

INSERT INTO OrderDetails VALUES (8,7,5,GETDATE())

INSERT INTO OrderDetails VALUES (8,9,10,GETDATE())

INSERT INTO OrderDetails VALUES (9,2,11,GETDATE())

INSERT INTO OrderDetails VALUES (9,7,11,GETDATE())
