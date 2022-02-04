package com.fstg.bookerorderservice.infra.dao;

import com.fstg.bookerorderservice.infra.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {

}
