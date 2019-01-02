package com.example.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stockservice.entity.UserStock;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Integer> {

}