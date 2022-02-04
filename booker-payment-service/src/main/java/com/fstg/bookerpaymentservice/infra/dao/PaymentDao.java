package com.fstg.bookerpaymentservice.infra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.bookerpaymentservice.infra.entity.PaymentEntity;


@Repository
public interface PaymentDao extends JpaRepository<PaymentEntity, Long> {
    PaymentEntity findByReference(String reference);

    int deleteByReference(String reference);

    @Query("SELECT p FROM  PaymentEntity  p where  p.amount > :amount")
    List<PaymentEntity> findPaymentSup(@Param("amount") double amount);
}
