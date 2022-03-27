/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Customer;
import io.arpaul.myshop.payload.shared.CustomerDto;
import io.arpaul.myshop.repositories.CustomerRepository;
import io.arpaul.myshop.services.listeners.CustomerService;

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
public class CustomerServiceImpl implements CustomerService {
    
    private final CustomerRepository customerRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
    @Override
	public CustomerDto create(CustomerDto customerDto) {
        log.debug("Request to create Customer: {}", customerDto);
        return mapToDto(
                this.customerRepository.save(
                        new Customer(
                                customerDto.getFirstName(),
                                customerDto.getLastName(),
                                customerDto.getEmail(),
                                customerDto.getTelephone(),
                                Collections.emptySet(),
                                Boolean.TRUE
                        )
                )
        );
    }
    @Override
    public List<CustomerDto> findAll() {
        log.debug("Request to get all Customer");
        return this.customerRepository.findAll()
                .stream()
                .map(CustomerServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        log.debug("Request to get Customer : {}", id);
        return this.customerRepository.findById(id)
                .map(CustomerServiceImpl::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }
    @Override
    public List<CustomerDto> findAllActive() {
        log.debug("Request to get all Customer");
        return this.customerRepository.findByEnabled(true)
                .stream()
                .map(CustomerServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<CustomerDto> findAllInActive() {
        log.debug("Request to get all Customer");
        return this.customerRepository.findByEnabled(false)
                .stream()
                .map(CustomerServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        Customer cart = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));
        cart.setEnabled(false);
        this.customerRepository.save(cart);
    }
    
    public static CustomerDto mapToDto(Customer customer) {
        if(customer != null) {
            return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getTelephone()
            );
        }
        return null;
    }
}
