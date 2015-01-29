package com.ippon.service;

import org.springframework.stereotype.Service;

import com.ippon.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean isVIP(Customer customer) {
        final Query query = entityManager.createQuery("select count(*) from Customer customer join customer.discountPrograms discountProgram where customer.id = :id and discountProgram.name = 'Platinum Discount Program'")
                .setParameter("id", customer.getId());
        return (Long) query.getSingleResult() > 0;
    }
}