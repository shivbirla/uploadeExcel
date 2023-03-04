package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
