/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ARPaul
 */
@Entity
@Table(name = "review")
public class Review extends AbstractEntity {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2407952110716074556L;

	@NotNull
    @Column(name = "text", nullable = false)
    private String title;
    
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    
    @NotNull
    @Column(name = "rating", nullable = false)
    private Long rating;

	public Review() {
		super();
	}

	public Review(@NotNull String title, @NotNull String description, @NotNull Long rating) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [title=" + title + ", description=" + description + ", rating=" + rating + "]";
	}
    
}
