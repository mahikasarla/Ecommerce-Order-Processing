package com.example.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MahenderKasarla
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderVO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String orderId;
	private String orderStatus;
	private String orderCustomerId;
	private String orderItemName;
	private String orderItemQty;
	private String orderSubtotal;
	private String orderTax;
	private String orderShippingCharges;
	private String orderTotal;
	private String orderPaymentMethod;
	private Date orderPaymentDate;
	private String orderPaymentConfirmationNumber;
	private OrderBillingAdressVO orderBillingAdressVO;
	private OrderShippingAdressVO orderShippingAdressVO;

}
