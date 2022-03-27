/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.shared.CustomerDto;
import java.util.List;

/**
 *
 * @author ARPaul
 */
public interface CustomerService {
	public CustomerDto create(CustomerDto customerDto);
    public List<CustomerDto> findAll();
    public CustomerDto findById(Long id);
    public List<CustomerDto> findAllActive();
    public List<CustomerDto> findAllInActive();
    public void delete(Long id);
}
