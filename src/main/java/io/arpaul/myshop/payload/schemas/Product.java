/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import io.arpaul.myshop.utils.ProductStatus;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ARPaul
 */

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5578632598779878017L;

	@NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    
    @NotNull
    @Column(name = "price", precision = 10, scale = 2,nullable = false)
    private BigDecimal price;
    
    @Column(name = "quantity")
    private Integer quantity;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;
    
    @Column(name = "sales_counter")
    private Integer salescounter;
    
    @OneToMany
    private Set<Review> reviews = new HashSet<>();
    
    @ManyToOne
    private Category category;

	public Product() {
		super();
	}

	public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price, Integer quantity,
			@NotNull ProductStatus status, Integer salescounter, Set<Review> reviews, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.salescounter = salescounter;
		this.reviews = reviews;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public Integer getSalescounter() {
		return salescounter;
	}

	public void setSalescounter(Integer salescounter) {
		this.salescounter = salescounter;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ ", status=" + status + ", salescounter=" + salescounter + ", reviews=" + reviews + ", category="
				+ category + "]";
	}
    
}
