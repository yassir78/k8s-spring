package com.fstg.bookerorderservice.infra.dao;

import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
    public CustomerOrderEntity findByRef(String ref);

    public int deleteByRef(String ref);
}
