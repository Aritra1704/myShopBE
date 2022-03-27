/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.shared;

/**
 *
 * @author ARPaul
 */
public class OrderItemDto {
    private Long id;
    private Long quantity;
    private Long productId;
    private Long orderId;
    
	public OrderItemDto() {
		super();
	}
	public OrderItemDto(Long id, Long quantity, Long productId, Long orderId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.productId = productId;
		this.orderId = orderId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderItemDto [id=" + id + ", quantity=" + quantity + ", productId=" + productId + ", orderId=" + orderId
				+ "]";
	}
    
}
