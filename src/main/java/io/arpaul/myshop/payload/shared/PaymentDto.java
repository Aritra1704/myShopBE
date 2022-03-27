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
public class PaymentDto {
    private Long id;
    private String paymentId;
    private String status;
    private Long  orderid;
    
	public PaymentDto() {
		super();
	}
	public PaymentDto(Long id, String paymentId, String status, Long orderid) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.status = status;
		this.orderid = orderid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", paymentId=" + paymentId + ", status=" + status + ", orderid=" + orderid
				+ "]";
	}
    
}
