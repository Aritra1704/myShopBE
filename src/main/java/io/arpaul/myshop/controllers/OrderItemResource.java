/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.controllers;

import io.arpaul.myshop.payload.shared.OrderItemDto;
import io.arpaul.myshop.services.listeners.OrderItemService;
import io.arpaul.myshop.utils.Web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ARPaul
 */
@RestController
@RequestMapping(Web.API + "/order-items")
public class OrderItemResource {
	@Autowired
    private OrderItemService orderItemService;
    
    @GetMapping
    public List<OrderItemDto> findAll() {
        return this.orderItemService.findAll();
    }
    
    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable Long id) {
        return this.orderItemService.findById(id);
    }
    
    @PostMapping
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return this.orderItemService.create(orderItemDto);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderItemService.delete(id);
    }
}
