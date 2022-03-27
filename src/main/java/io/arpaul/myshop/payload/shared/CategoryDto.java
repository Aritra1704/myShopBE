/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.shared;

import java.util.Set;

/**
 *
 * @author ARPaul
 */

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Set<ProductDto> products;
    
	public CategoryDto(Long id, String name, String description, Set<ProductDto> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
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
	public Set<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
				+ "]";
	}
    
}
