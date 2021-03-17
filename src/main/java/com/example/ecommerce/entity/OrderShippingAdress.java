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
@Table(name = "order_shipping_address")
@Getter
@Setter
@NoArgsConstructor
public class OrderShippingAdress extends Auditable implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "order_shipping_addressline1")
	private String orderShippingAddressline1;

	@Column(name = "order_shipping_addressline2")
	private String orderShippingAddressline2;

	@Column(name = "order_shipping_city")
	private String orderShippingCity;

	@Column(name = "order_shipping_state")
	private String orderShippingState;

	@Column(name = "order_shipping_zip")
	private String orderShippingZip;

}
