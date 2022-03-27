/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ARPaul
 */
@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -481641613552581939L;

	@NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Order  order;

	public OrderItem() {
		super();
	}

	public OrderItem(@NotNull Long quantity, Product product, Order order) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", product=" + product + ", order=" + order + "]";
	}
    
    
}
