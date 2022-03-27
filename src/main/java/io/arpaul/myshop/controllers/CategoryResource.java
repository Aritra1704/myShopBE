/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.controllers;

import io.arpaul.myshop.payload.shared.CategoryDto;
import io.arpaul.myshop.services.listeners.CategoryService;
import io.arpaul.myshop.utils.Web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ARPaul
 */
@RestController
@RequestMapping(Web.API + "/categories")
public class CategoryResource {
	@Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }
    
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }
    
    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.delete(id);
    }
}
