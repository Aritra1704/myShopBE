/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.shared.CategoryDto;
import java.util.List;

/**
 *
 * @author ARPaul
 */
public interface CategoryService {
	public List<CategoryDto> findAll();
    public CategoryDto findById(Long id);
    public CategoryDto create(CategoryDto categoryDto);
    public void delete(Long id);
}
