CREATE TABLE item_order (
	id INT GENERATED ALWAYS AS IDENTITY,
	order_id VARCHAR ( 50 ) UNIQUE NOT NULL,
	order_status VARCHAR ( 50 ) NOT NULL,
	order_item_name VARCHAR ( 255 ) UNIQUE NOT NULL,
	
	order_customer_id VARCHAR ( 50 ) UNIQUE NOT NULL,
	order_item_qty VARCHAR ( 50 ) NOT NULL,
	order_subtotal VARCHAR ( 255 ) NOT NULL,
	order_tax VARCHAR ( 50 ) NOT NULL,
	order_shipping_charges VARCHAR ( 50 ) NOT NULL,
	order_total VARCHAR ( 255 ) NOT NULL,
	
  order_payment_method VARCHAR ( 50 ) NOT NULL,
	order_payment_date TIMESTAMP NOT NULL,
	order_payment_confirmation_number VARCHAR ( 255 ) UNIQUE NOT NULL,
	billing_address_id INTEGER NOT NULL,
	shipping_address_id INTEGER NOT NULL,	
	created_by VARCHAR ( 50 ) NOT NULL,
	last_modified_by VARCHAR ( 50 ) NOT NULL,
	created_date TIMESTAMP NOT NULL,
	last_modified_date TIMESTAMP NOT NULL,
	
  PRIMARY KEY (billing_address_id, shipping_address_id),
  FOREIGN KEY (billing_address_id)
      REFERENCES order_billing_address (id),
  FOREIGN KEY (shipping_address_id)
      REFERENCES order_shipping_address (id)
);