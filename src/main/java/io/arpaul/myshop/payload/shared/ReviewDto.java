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
public class ReviewDto {
    private Long id;
    private String title;
    private String description;
    private Long rating;
    
	public ReviewDto(Long id, String title, String description, Long rating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "ReviewDto [id=" + id + ", title=" + title + ", description=" + description + ", rating=" + rating + "]";
	}
    
}
