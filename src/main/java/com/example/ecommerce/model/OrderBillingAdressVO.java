package com.example.ecommerce.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderBillingAdressVO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String orderBillingAddressline1;

	private String orderBillingAddressline2;

	private String orderBillingCity;

	private String orderBillingState;

	private String orderBillingZip;

}
