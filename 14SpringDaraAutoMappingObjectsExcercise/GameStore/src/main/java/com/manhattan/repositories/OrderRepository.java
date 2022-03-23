package com.manhattan.repositories;

import com.manhattan.models.entities.Order;
import com.manhattan.models.entities.OrderStatus;
import com.manhattan.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<Order> findOneByBuyerAndOrderStatus(User user, OrderStatus status);
}
