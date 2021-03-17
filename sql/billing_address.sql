CREATE TABLE order_billing_address (
	id INTEGER PRIMARY KEY,
	order_billing_addressline1 VARCHAR ( 50 ) NOT NULL,
	order_billing_addressline2 VARCHAR ( 50 ) NOT NULL,
	order_billing_city VARCHAR ( 50 ) NOT NULL,
	order_billing_state VARCHAR ( 50 ) NOT NULL,
	order_billing_zip VARCHAR ( 50 ) NOT NULL
);