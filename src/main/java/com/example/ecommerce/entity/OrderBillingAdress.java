package com.example.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_billing_address")
@Getter
@Setter
@NoArgsConstructor
public class OrderBillingAdress extends Auditable implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "order_billing_addressline1")
	private String orderBillingAddressline1;

	@Column(name = "order_billing_addressline2")
	private String orderBillingAddressline2;

	@Column(name = "order_billing_city")
	private String orderBillingCity;

	@Column(name = "order_billing_state")
	private String orderBillingState;

	@Column(name = "order_billing_zip")
	private String orderBillingZip;

}
