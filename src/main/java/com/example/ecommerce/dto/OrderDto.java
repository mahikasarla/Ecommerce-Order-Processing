package com.example.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderBillingAdress;
import com.example.ecommerce.entity.OrderShippingAdress;
import com.example.ecommerce.model.OrderBillingAdressVO;
import com.example.ecommerce.model.OrderShippingAdressVO;
import com.example.ecommerce.model.OrderVO;

/**
 * @author MahenderKasarla
 *
 */
@Service
public class OrderDto {

	/**
	 * transfers List of Order's to List of orderVO's
	 *
	 * @param orderEntities
	 * @return List of {@link OrderVO}
	 */
	public List<OrderVO> getOrderVOs(List<Order> orderEntities) {
		List<OrderVO> orders = new ArrayList<OrderVO>();
		for (Order orderEntity : orderEntities) {
			orders.add(getOrderVO(orderEntity));
		}
		return orders;
	}

	/**
	 * transfers Order to OrderVO
	 *
	 * @param order
	 * @return {@link OrderVO}
	 */
	public OrderVO getOrderVO(Order order) {
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderId(order.getOrderId());
		orderVO.setOrderCustomerId(order.getOrderCustomerId());
		orderVO.setOrderItemName(order.getOrderItemName());
		orderVO.setOrderItemQty(order.getOrderItemQty());
		orderVO.setOrderPaymentConfirmationNumber(order.getOrderPaymentConfirmationNumber());
		orderVO.setOrderPaymentDate(order.getOrderPaymentDate());
		orderVO.setOrderPaymentMethod(order.getOrderPaymentMethod());
		orderVO.setOrderShippingCharges(order.getOrderShippingCharges());
		orderVO.setOrderStatus(order.getOrderStatus());
		orderVO.setOrderSubtotal(order.getOrderSubtotal());
		orderVO.setOrderTax(order.getOrderTax());
		orderVO.setOrderTotal(order.getOrderTotal());
		orderVO.setOrderBillingAdressVO(convertToBillingAddressVO(order.getOrderBillingAdress()));
		orderVO.setOrderShippingAdressVO(convertToShippingAddressVO(order.getOrderShippingAdress()));
		return orderVO;
	}

	/**
	 * transfer OrderShippingAdress to OrderShippingAdressVO
	 *
	 * @param orderShippingAdress
	 *
	 * @return {@link OrderShippingAdressVO}
	 */
	private OrderShippingAdressVO convertToShippingAddressVO(OrderShippingAdress orderShippingAdress) {
		OrderShippingAdressVO orderShippingAdressVO = new OrderShippingAdressVO();
		orderShippingAdressVO.setOrderShippingAddressline1(orderShippingAdress.getOrderShippingAddressline1());
		orderShippingAdressVO.setOrderShippingAddressline2(orderShippingAdress.getOrderShippingAddressline2());
		orderShippingAdressVO.setOrderShippingCity(orderShippingAdress.getOrderShippingCity());
		orderShippingAdressVO.setOrderShippingState(orderShippingAdress.getOrderShippingState());
		orderShippingAdressVO.setOrderShippingZip(orderShippingAdress.getOrderShippingZip());
		return orderShippingAdressVO;
	}

	/**
	 * transfer OrderBillingAdress to OrderBillingAdressVO
	 *
	 * @param orderBillingAdressVO
	 *
	 * @return {@link OrderBillingAdressVO}
	 */
	private OrderBillingAdressVO convertToBillingAddressVO(OrderBillingAdress orderBillingAdress) {
		OrderBillingAdressVO orderBillingAdressVO = new OrderBillingAdressVO();
		orderBillingAdressVO.setOrderBillingAddressline1(orderBillingAdress.getOrderBillingAddressline1());
		orderBillingAdressVO.setOrderBillingAddressline2(orderBillingAdress.getOrderBillingAddressline2());
		orderBillingAdressVO.setOrderBillingCity(orderBillingAdress.getOrderBillingCity());
		orderBillingAdressVO.setOrderBillingState(orderBillingAdress.getOrderBillingState());
		orderBillingAdressVO.setOrderBillingZip(orderBillingAdress.getOrderBillingZip());
		return orderBillingAdressVO;
	}

	/**
	 * transfers OrderVO to Order
	 *
	 * @param orderVO
	 * @return {@link Order}
	 */
	public Order getEntityOrder(OrderVO orderVO) {
		Order orderEntity = new Order();
		return getEntityOrder(orderEntity, orderVO);
	}

	/**
	 * transfers List of OrderVO to List of Order
	 *
	 * @param orderVOs
	 * @return {@link Order}
	 */
	public List<Order> getEntityOrders(List<OrderVO> orderVOs) {
		List<Order> orderEntities = new ArrayList<Order>();
		for (OrderVO order : orderVOs) {
			Order orderEntity = new Order();
			orderEntities.add(getEntityOrder(orderEntity, order));
		}
		return orderEntities;
	}

	/**
	 * updates order object from orderVO
	 *
	 * @param entityOrder
	 * @param orderVO
	 * @return {@link Order}
	 */
	public Order getEntityOrder(Order entityOrder, OrderVO orderVO) {
		entityOrder.setOrderId(orderVO.getOrderId());
		entityOrder.setOrderCustomerId(orderVO.getOrderCustomerId());
		entityOrder.setOrderItemName(orderVO.getOrderItemName());
		entityOrder.setOrderItemQty(orderVO.getOrderItemQty());
		entityOrder.setOrderPaymentConfirmationNumber(orderVO.getOrderPaymentConfirmationNumber());
		entityOrder.setOrderPaymentDate(orderVO.getOrderPaymentDate());
		entityOrder.setOrderPaymentMethod(orderVO.getOrderPaymentMethod());
		entityOrder.setOrderShippingCharges(orderVO.getOrderShippingCharges());
		entityOrder.setOrderStatus(orderVO.getOrderStatus());
		entityOrder.setOrderSubtotal(orderVO.getOrderSubtotal());
		entityOrder.setOrderTax(orderVO.getOrderTax());
		entityOrder.setOrderTotal(orderVO.getOrderTotal());
		entityOrder.setOrderBillingAdress(convertToBillingAddress(orderVO.getOrderBillingAdressVO()));
		entityOrder.setOrderShippingAdress(convertToShippingAddress(orderVO.getOrderShippingAdressVO()));
		return entityOrder;
	}

	/**
	 * converts orderShippingAdressVO to orderShippingAdress
	 *
	 * @param orderShippingAdressVO
	 * @return {@link OrderBillingAdressVO}
	 */
	private OrderShippingAdress convertToShippingAddress(OrderShippingAdressVO orderShippingAdressVO) {
		OrderShippingAdress orderShippingAdress = new OrderShippingAdress();
		orderShippingAdress.setOrderShippingAddressline1(orderShippingAdressVO.getOrderShippingAddressline1());
		orderShippingAdress.setOrderShippingAddressline2(orderShippingAdressVO.getOrderShippingAddressline2());
		orderShippingAdress.setOrderShippingCity(orderShippingAdressVO.getOrderShippingCity());
		orderShippingAdress.setOrderShippingState(orderShippingAdressVO.getOrderShippingState());
		orderShippingAdress.setOrderShippingZip(orderShippingAdressVO.getOrderShippingZip());
		return orderShippingAdress;
	}

	/**
	 * converts orderBillingAdressVO to orderBillingAdress
	 *
	 * @param orderBillingAdressVO
	 * @return {@link OrderBillingAdress}
	 */
	private OrderBillingAdress convertToBillingAddress(OrderBillingAdressVO orderBillingAdressVO) {
		OrderBillingAdress orderBillingAdress = new OrderBillingAdress();
		orderBillingAdress.setOrderBillingAddressline1(orderBillingAdressVO.getOrderBillingAddressline1());
		orderBillingAdress.setOrderBillingAddressline2(orderBillingAdressVO.getOrderBillingAddressline2());
		orderBillingAdress.setOrderBillingCity(orderBillingAdressVO.getOrderBillingCity());
		orderBillingAdress.setOrderBillingState(orderBillingAdressVO.getOrderBillingState());
		orderBillingAdress.setOrderBillingZip(orderBillingAdressVO.getOrderBillingZip());
		return orderBillingAdress;
	}

}
