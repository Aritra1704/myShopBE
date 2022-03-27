/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author ARPaul
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2602479999297416118L;

	@NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

	public Category() {
		super();
	}

	public Category(@NotNull String name, @NotNull String description, Set<Product> products) {
		super();
		this.name = name;
		this.description = description;
		this.products = products;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", products=" + products + "]";
	}
}
