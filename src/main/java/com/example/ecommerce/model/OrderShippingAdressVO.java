package com.example.ecommerce.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderShippingAdressVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String orderShippingAddressline1;

	private String orderShippingAddressline2;

	private String orderShippingCity;

	private String orderShippingState;

	private String orderShippingZip;
}
