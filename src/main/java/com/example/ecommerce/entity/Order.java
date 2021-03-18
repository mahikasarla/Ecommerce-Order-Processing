package com.example.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MahenderKasarla
 *
 */
@Entity
@Table(name = "item_order")
@Getter
@Setter
@NoArgsConstructor
public class Order extends Auditable implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "order_id")
	private String orderId;
	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "order_customer_id")
	private String orderCustomerId;
	@Column(name = "order_item_name")
	private String orderItemName;
	@Column(name = "order_item_qty")
	private String orderItemQty;
	@Column(name = "order_subtotal")
	private String orderSubtotal;
	@Column(name = "order_tax")
	private String orderTax;
	@Column(name = "order_shipping_charges")
	private String orderShippingCharges;
	@Column(name = "order_total")
	private String orderTotal;
	@Column(name = "order_payment_method")
	private String orderPaymentMethod;
	@Column(name = "order_payment_date")
	private Date orderPaymentDate;
	@Column(name = "order_payment_confirmation_number")
	private String orderPaymentConfirmationNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id", referencedColumnName = "id")
	private OrderBillingAdress orderBillingAdress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
	private OrderShippingAdress orderShippingAdress;

}
