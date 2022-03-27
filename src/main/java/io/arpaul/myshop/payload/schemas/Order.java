/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.arpaul.myshop.utils.OrderStatus;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ARPaul
 */

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8668284326521539994L;

	@NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;
    
    @Column(name = "shipped")
    private ZonedDateTime shipped;
    
    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;
    
    @Embedded
    private Address shipmentAddress;
    
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderItem> orderItems;
    
    @OneToOne(mappedBy = "order")
    @JsonIgnore
    private Cart cart;

	public Order() {
		super();
	}

	public Order(@NotNull BigDecimal totalPrice, @NotNull OrderStatus status, ZonedDateTime shipped, Payment payment,
			Address shipmentAddress, Set<OrderItem> orderItems, Cart cart) {
		super();
		this.totalPrice = totalPrice;
		this.status = status;
		this.shipped = shipped;
		this.payment = payment;
		this.shipmentAddress = shipmentAddress;
		this.orderItems = orderItems;
		this.cart = cart;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ZonedDateTime getShipped() {
		return shipped;
	}

	public void setShipped(ZonedDateTime shipped) {
		this.shipped = shipped;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Address getShipmentAddress() {
		return shipmentAddress;
	}

	public void setShipmentAddress(Address shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [totalPrice=" + totalPrice + ", status=" + status + ", shipped=" + shipped + ", payment="
				+ payment + ", shipmentAddress=" + shipmentAddress + ", orderItems=" + orderItems + ", cart=" + cart
				+ "]";
	}
    
}
