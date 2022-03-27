/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.shared.CartDto;
import java.util.List;

/**
 *
 * @author ARPaul
 */
public interface CartService {
	public List<CartDto> findAll();
    public List<CartDto> findAllActiveCarts();
    public CartDto create(Long customerId);
    public CartDto findById(Long id);
    public void delete(Long id);
    public CartDto getActiveCart(Long customerId);
}
