package com.example.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentservice.repository.entity.UserPayment;

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Integer> {

}