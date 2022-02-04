package com.fstg.bookerpaymentservice.infra.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fstg.bookerpaymentservice.domain.pojo.Payment;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerpaymentservice.infra.dao.PaymentDao;
import com.fstg.bookerpaymentservice.infra.entity.PaymentEntity;
import com.fstg.bookerpaymentservice.infra.facade.PaymentInfra;
import com.fstg.bookerpaymentservice.infra.helper.PaymentSearch;




@Component
public class PaymentInfraImpl extends AbstractInfraImpl implements PaymentInfra {

    @Autowired
    private EntityManager entityManager;
    @Override
    public Payment findByReference(String reference) {
    	PaymentEntity paymentEntity = paymentDao.findByReference(reference);
    	Payment payment = new Payment();
        if (paymentEntity != null) {
            BeanUtils.copyProperties(paymentEntity, payment);
        }
        return payment;
    }

    @Override
    public int deleteByReference(String reference) {
        return paymentDao.deleteByReference(reference);
    }

    @Override
    public int save(Payment payment) {
    	PaymentEntity paymentEntity = new PaymentEntity();
            BeanUtils.copyProperties(payment, paymentEntity);
            if( payment.getOrderReference() !=null && !payment.getOrderReference().isEmpty()){
            	paymentEntity.setOrderReference("");
            }
            paymentEntity.setOrderReference(payment.getOrderReference());
            paymentDao.save(paymentEntity);
            return 1;
    }

    public List<PaymentEntity> search(PaymentSearch paymentSearch) {
        String query=init(PaymentEntity.class);
        query+=addCriteria("amount",paymentSearch.getAmountMin(),paymentSearch.getAmountMax());
        query+=addCriteria("reference",paymentSearch.getReference(),"LIKE");
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    @Autowired
    private PaymentDao paymentDao;
}

