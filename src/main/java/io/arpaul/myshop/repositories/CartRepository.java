package io.arpaul.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.arpaul.myshop.payload.schemas.Cart;
import io.arpaul.myshop.utils.CartStatus;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	List<Cart> findByStatus(CartStatus status);
	List<Cart> findByStatusAndCustomerId(CartStatus status, Long CustomerId);
}
