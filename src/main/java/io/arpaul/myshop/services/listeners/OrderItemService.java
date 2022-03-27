/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.schemas.Customer;
import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.schemas.OrderItem;
import io.arpaul.myshop.payload.schemas.Product;
import io.arpaul.myshop.payload.shared.CustomerDto;
import io.arpaul.myshop.payload.shared.OrderItemDto;
import io.arpaul.myshop.repositories.OrderItemRepository;
import io.arpaul.myshop.repositories.OrderRepository;
import io.arpaul.myshop.repositories.ProductRepository;
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
public interface OrderItemService {
   	public OrderItemDto create(OrderItemDto orderItemDto);
    public List<OrderItemDto> findAll();
    public OrderItemDto findById(Long id);
    public void delete(Long id);
}
