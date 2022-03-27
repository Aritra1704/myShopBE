/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.shared;

import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author ARPaul
 */
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String status;
    private Integer salescounter;
    private Set<ReviewDto> reviews;
    private CategoryDto category;
    
	public ProductDto(Long id, String name, String description, BigDecimal price, Integer quantity, String status,
			Integer salescounter, Set<ReviewDto> reviews, CategoryDto category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.salescounter = salescounter;
		this.reviews = reviews;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getSalescounter() {
		return salescounter;
	}
	public void setSalescounter(Integer salescounter) {
		this.salescounter = salescounter;
	}
	public Set<ReviewDto> getReviews() {
		return reviews;
	}
	public void setReviews(Set<ReviewDto> reviews) {
		this.reviews = reviews;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", status=" + status + ", salescounter=" + salescounter + ", reviews="
				+ reviews + ", category=" + category + "]";
	}
    
}
