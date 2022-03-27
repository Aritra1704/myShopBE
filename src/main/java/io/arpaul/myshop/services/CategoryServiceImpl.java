/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Category;
import io.arpaul.myshop.payload.shared.CategoryDto;
import io.arpaul.myshop.repositories.CategoryRepository;
import io.arpaul.myshop.services.listeners.CategoryService;

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
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
    @Override
	public List<CategoryDto> findAll() {
        log.debug("Request to get all Categories");
        return this.categoryRepository.findAll()
                .stream()
                .map(CategoryServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        log.debug("Request to get Cart : {}", id);
        return this.categoryRepository.findById(id)
                .map(CategoryServiceImpl::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        log.debug("Request to create Category : {}", categoryDto);
        return mapToDto(this.categoryRepository.save(
                new Category(
                        categoryDto.getName(),
                        categoryDto.getDescription(),
                        Collections.emptySet()
                )
        ));
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        this.categoryRepository.deleteById(id);
    }
    
    public static CategoryDto mapToDto(Category category) {
        if(category != null) {
            return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts()
                    .stream()
                    .map(ProductServiceImpl::mapToDto)
                    .collect(Collectors.toSet())
            );
        }
        return null;
    }
}
