/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.schemas.OrderItem;
import io.arpaul.myshop.payload.schemas.Product;
import io.arpaul.myshop.payload.shared.OrderItemDto;
import io.arpaul.myshop.repositories.OrderItemRepository;
import io.arpaul.myshop.repositories.OrderRepository;
import io.arpaul.myshop.repositories.ProductRepository;
import io.arpaul.myshop.services.listeners.OrderItemService;

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
public class OrderItemServiceImpl implements OrderItemService {
    
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository,
			ProductRepository productRepository) {
		super();
		this.orderItemRepository = orderItemRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
    @Override
	public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem: {}", orderItemDto);
        Order order = this.orderRepository.findById(orderItemDto.getOrderId())
                .orElseThrow(() -> new IllegalStateException("The order does not exist!"));
        Product product = this.productRepository.findById(orderItemDto.getProductId())
                .orElseThrow(() -> new IllegalStateException("The product does not exist!"));
        return mapToDto(
                this.orderItemRepository.save(
                        new OrderItem(
                                orderItemDto.getQuantity(),
                                product,
                                order
                        )
                )
        );
    }
    @Override
    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository.findById(id)
                .map(OrderItemServiceImpl::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }
    
    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if(orderItem != null) {
            return new OrderItemDto(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getProduct().getId(),
                orderItem.getOrder().getId()
            );
        }
        return null;
    }
}
