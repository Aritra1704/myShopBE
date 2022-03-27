/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import io.arpaul.myshop.utils.PaymentStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ARPaul
 */
@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -701501876214960810L;

	@Column(name = "paymentId")
    private String paymentId;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;
    
    @OneToOne
    @JoinColumn(unique = true)
    private Order  order;

	public Payment() {
		super();
	}

	public Payment(String paymentId, @NotNull PaymentStatus status, Order order) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.order = order;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", status=" + status + ", order=" + order + "]";
	}
    
    
}
