/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Cart;
import io.arpaul.myshop.payload.schemas.Customer;
import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.shared.CartDto;
import io.arpaul.myshop.repositories.CartRepository;
import io.arpaul.myshop.repositories.CustomerRepository;
import io.arpaul.myshop.services.listeners.CartService;
import io.arpaul.myshop.services.listeners.OrderService;
import io.arpaul.myshop.utils.CartStatus;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ARPaul
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {
    
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository,
			OrderService orderService) {
		super();
		this.cartRepository = cartRepository;
		this.customerRepository = customerRepository;
		this.orderService = orderService;
	}
    @Override
	public List<CartDto> findAll() {
        log.debug("Request to get all Carts");
        return this.cartRepository.findAll()
                .stream()
                .map(CartServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<CartDto> findAllActiveCarts() {
        log.debug("Request to get all Carts");
        return this.cartRepository.findByStatus(CartStatus.NEW)
                .stream()
                .map(CartServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public CartDto create(Long customerId) {
        if(this.getActiveCart(customerId) == null) {
            Customer customer = this.customerRepository.findById(customerId)
                    .orElseThrow(() -> new IllegalStateException("The customer does not exist"));
            
            Cart cart = new Cart(customer);
            Order order = this.orderService.create(cart);
            cart.setOrder(order);
            
            return mapToDto(this.cartRepository.save(cart));
        } else {
            throw new IllegalStateException("There is already an active cart");
        }
    }
    @Override
    @Transactional(readOnly = true)
    public CartDto findById(Long id) {
        log.debug("Request to get Cart : {}", id);
        return this.cartRepository.findById(id).map(CartServiceImpl::mapToDto).orElse(null);
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cart : {}", id);
        Cart cart = this.cartRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find cart with id " + id));
        cart.setStatus(CartStatus.CANCELED);
        this.cartRepository.save(cart);
    }
    @Override
    public CartDto getActiveCart(Long customerId) {
        List<Cart> carts = this.cartRepository.findByStatusAndCustomerId(CartStatus.NEW, customerId);
        if(carts != null) {
            if(carts.size() == 1) {
                return mapToDto(carts.get(0));
            }
            else if (carts.size() > 1) {
                throw new IllegalStateException("Many active carts detected !!");
            }
        }
        return null;
    }
    
    public static CartDto mapToDto(Cart cart) {
        if(cart != null) {
            return new CartDto(
                cart.getId(),
                cart.getOrder().getId(),
                CustomerServiceImpl.mapToDto(cart.getCustomer()),
                cart.getStatus().name()
            );
        }
        return null;
    }
}
