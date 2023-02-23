INSERT INTO USER_ENTITY (user_name, role, email, phone, address, login, password) VALUES
	 ('user1', 'ADMIN', 'email1', 'phone1', 'address1', 'login1', 'password1'),
	 ('user2', 'CUSTOMER', 'email2', 'phone2', 'address2', 'login2', 'password2'),
	 ('user3', 'MANAGER', 'email3', 'phone3', 'address3', 'login3', 'password3')
	 ;

INSERT INTO PRODUCT (product_name, description, author, price, image_path) VALUES
	 ('book1', 'description1', 'author1', 10.20, 'imagePath1'),
	 ('book2', 'description2', 'author2', 15.10, 'imagePath2'),
	 ('book3', 'description3', 'author3', 13.10, 'imagePath3')
	 ;

INSERT INTO STORE_ITEM (product_id, available_Qty, booked_Qty, sold_Qty) VALUES
	 (1, 10, 5, 50),
	 (2, 15, 3, 20),
	 (3, 20, 1, 10)
	 ;

INSERT INTO BOOKING (product_id, user_id, delivery_address, date, time, status, quantity) VALUES
	 (1, 1, 'Address1', '1989-09-29', '21:22:34', 'SUBMITTED', 5),
	 (2, 1, 'Address2', '1990-09-29', '21:22:34', 'APPROVED', 2),
	 (3, 1, 'Address3', '1991-09-29', '21:22:34', 'IN_DELIVERY', 1)
	 (2, 2, 'Address2', '1990-09-29', '21:22:34', 'APPROVED', 2),
	 (3, 3, 'Address3', '1991-09-29', '21:22:34', 'IN_DELIVERY', 1)
	 ;
