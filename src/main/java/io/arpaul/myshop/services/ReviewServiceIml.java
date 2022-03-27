/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Review;
import io.arpaul.myshop.payload.shared.ReviewDto;
import io.arpaul.myshop.repositories.ReviewRepository;
import io.arpaul.myshop.services.listeners.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ARPaul
 */
@Service
@Transactional
public class ReviewServiceIml implements ReviewService {
    
    private final ReviewRepository reviewRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public ReviewServiceIml(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
    
    public static ReviewDto mapToDto(Review payment) {
        if(payment != null) {
            return new ReviewDto(
                payment.getId(),
                payment.getTitle(),
                payment.getDescription(),
                payment.getRating()
            );
        }
        return null;
    }

	@Override
	public ReviewDto create(ReviewDto reviewDto) {
		log.debug("Request to create Review: {}", reviewDto);
        
        return mapToDto(
                this.reviewRepository.save(
                        new Review(
                                reviewDto.getTitle(),
                                reviewDto.getDescription(),
                                reviewDto.getRating()
                        )
                )
        );
	}

	@Override
	public List<ReviewDto> findAll() {
		log.debug("Request to get all Reviews");
        return this.reviewRepository.findAll()
                .stream()
                .map(ReviewServiceIml::mapToDto)
                .collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public ReviewDto findById(Long id) {
		log.debug("Request to get Review : {}", id);
        return this.reviewRepository.findById(id)
                .map(ReviewServiceIml::mapToDto)
                .orElse(null);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Review : {}", id);
        this.reviewRepository.deleteById(id);
	}
}
