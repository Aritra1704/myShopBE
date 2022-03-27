package io.arpaul.myshop.payload.schemas;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.arpaul.myshop.utils.CartStatus;

@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -568875602257351155L;

	@OneToOne
	@JoinColumn(unique = true)
	private Order order;
	
	@ManyToOne
	private Customer customer;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CartStatus  status;

	public Cart() {
		super();
	}

	public Cart(Customer customer) {
		super();
		this.customer = customer;
		this.status = CartStatus.NEW;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [order=" + order + ", customer=" + customer + ", status=" + status + "]";
	}
	
	
}
