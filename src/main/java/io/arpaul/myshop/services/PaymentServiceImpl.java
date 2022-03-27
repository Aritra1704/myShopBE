/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Order;
import io.arpaul.myshop.payload.schemas.Payment;
import io.arpaul.myshop.payload.shared.PaymentDto;
import io.arpaul.myshop.repositories.OrderRepository;
import io.arpaul.myshop.repositories.PaymentRepository;
import io.arpaul.myshop.services.listeners.PaymentService;
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
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
		super();
		this.paymentRepository = paymentRepository;
		this.orderRepository = orderRepository;
	}
    @Override
	public PaymentDto create(PaymentDto paymentDto) {
        log.debug("Request to create Payment: {}", paymentDto);
        Order order = this.orderRepository.findById(paymentDto.getOrderid())
                .orElseThrow(() -> new IllegalStateException("The Order does not exist!"));
        
        return mapToDto(
                this.paymentRepository.save(
                        new Payment(
                                paymentDto.getPaymentId(),
                                PaymentStatus.valueOf(paymentDto.getStatus()),
                                order
                        )
                )
        );
    }
    @Override
    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
                .stream()
                .map(PaymentServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository.findById(id)
                .map(PaymentServiceImpl::mapToDto)
                .orElse(null);
    }
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }
    
    public static PaymentDto mapToDto(Payment payment) {
        if(payment != null) {
            return new PaymentDto(
                payment.getId(),
                payment.getPaymentId(),
                payment.getStatus().name(),
                payment.getOrder().getId()
            );
        }
        return null;
    }
}
