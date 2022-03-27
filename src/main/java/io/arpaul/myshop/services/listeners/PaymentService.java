/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services.listeners;

import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.schemas.Payment;
import io.arpaul.myshop.payload.shared.PaymentDto;
import io.arpaul.myshop.repositories.OrderRepository;
import io.arpaul.myshop.repositories.PaymentRepository;
import io.arpaul.myshop.utils.PaymentStatus;
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
public interface PaymentService {
	public PaymentDto create(PaymentDto paymentDto);
    public List<PaymentDto> findAll();
    public PaymentDto findById(Long id);
    public void delete(Long id);
}
