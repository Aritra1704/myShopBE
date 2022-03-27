/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Product;
import io.arpaul.myshop.payload.shared.ProductDto;
import io.arpaul.myshop.repositories.CategoryRepository;
import io.arpaul.myshop.repositories.ProductRepository;
import io.arpaul.myshop.services.listeners.ProductService;
import io.arpaul.myshop.utils.ProductStatus;
import java.util.Collections;
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
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

    @Override
	public ProductDto create(ProductDto productDto) {
        log.debug("Request to create Product: {}", productDto);
        
        return mapToDto(
                this.productRepository.save(
                        new Product(
                                productDto.getName(),
                                productDto.getDescription(),
                                productDto.getPrice(),
                                productDto.getQuantity(),
                                ProductStatus.valueOf(productDto.getStatus()),
                                productDto.getSalescounter(),
                                Collections.emptySet(),
                                this.categoryRepository.findById(productDto.getCategory().getId())
                                        .orElse(null)
                        )
                )
        );
    }
    
    @Override
    public List<ProductDto> findAll() {
        log.debug("Request to get all Products");
        return this.productRepository.findAll()
                .stream()
                .map(ProductServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        log.debug("Request to get Product : {}", id);
        return this.productRepository.findById(id)
                .map(ProductServiceImpl::mapToDto)
                .orElse(null);
    }
    
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        this.productRepository.deleteById(id);
    }
    
    public static ProductDto mapToDto(Product product) {
        if(product != null) {
            return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getStatus().name(),
                product.getSalescounter(),
                product.getReviews()
                        .stream()
                        .map(ReviewServiceIml::mapToDto)
                        .collect(Collectors.toSet()),
                CategoryServiceImpl.mapToDto(product.getCategory())
            );
        }
        return null;
    }
}
