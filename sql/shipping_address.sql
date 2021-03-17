CREATE TABLE order_shipping_address (
	id INTEGER PRIMARY KEY,
	order_shipping_addressline1 VARCHAR ( 50 ) NOT NULL,
	order_shipping_addressline2 VARCHAR ( 50 ) NOT NULL,
	order_shipping_city VARCHAR ( 50 ) NOT NULL,
	order_shipping_state VARCHAR ( 50 ) NOT NULL,
	order_shipping_zip VARCHAR ( 50 ) NOT NULL
);