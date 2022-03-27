/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.schemas.Cart;
import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.shared.OrderDto;
import io.arpaul.myshop.repositories.OrderRepository;
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
public interface OrderService {
	public OrderDto create(OrderDto orderItemDto);
    public Order create(Cart cart);
    public List<OrderDto> findAll();
    public OrderDto findById(Long id);
    public List<OrderDto> findAllByUser(Long id);
    public void delete(Long id);
}
