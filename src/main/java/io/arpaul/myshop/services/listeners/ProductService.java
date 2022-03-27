/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.shared.ProductDto;
import java.util.List;

/**
 *
 * @author ARPaul
 */
public interface ProductService {
	public ProductDto create(ProductDto productDto);
    public List<ProductDto> findAll();
    public ProductDto findById(Long id);
    public void delete(Long id);

}
