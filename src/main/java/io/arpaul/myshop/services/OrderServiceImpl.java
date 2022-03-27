/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Cart;
import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.shared.OrderDto;
import io.arpaul.myshop.repositories.OrderRepository;
import io.arpaul.myshop.services.listeners.OrderService;
import io.arpaul.myshop.utils.OrderStatus;
import java.math.BigDecimal;
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
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

    @Override
	public OrderDto create(OrderDto orderItemDto) {
        log.debug("Request to create Order: {}", orderItemDto);
        return mapToDto(
                this.orderRepository.save(
                        new Order(
                                BigDecimal.ZERO,
                                OrderStatus.CREATION,
                                null,
                                null,
                                null,
                                Collections.emptySet(),
                                null
                        )
                )
        );
    }
    @Override
    public Order create(Cart cart) {
        log.debug("Request to create Order with a cart: {}", cart);
        return this.orderRepository.save(
                    new Order(
                            BigDecimal.ZERO,
                            OrderStatus.CREATION,
                            null,
                            null,
                            null,
                            Collections.emptySet(),
                            cart
                    )
               
        );
    }
    @Override
    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Orders : {}", id);
        return this.orderRepository.findById(id)
                .map(OrderServiceImpl::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }
    @Override
    public List<OrderDto> findAllByUser(Long id) {
        log.debug("Request to get all Orders");
        return this.orderRepository.findByCartCustomer_id(id)
                .stream()
                .map(OrderServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }
    
    public static OrderDto mapToDto(Order order) {
        if(order != null) {
            return new OrderDto(
                order.getId(),
                order.getTotalPrice(),
                order.getStatus().name(),
                order.getShipped(),
                PaymentServiceImpl.mapToDto(order.getPayment()),
                AddressService.mapToDto(order.getShipmentAddress()),
                order.getOrderItems()
                    .stream()
                    .map(OrderItemServiceImpl::mapToDto)
                    .collect(Collectors.toSet())
            );
        }
        return null;
    }
}
