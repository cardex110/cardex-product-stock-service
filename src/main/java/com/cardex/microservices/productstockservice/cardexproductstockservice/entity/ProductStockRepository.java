package com.cardex.microservices.productstockservice.cardexproductstockservice.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {

    ProductStock findByProductNameAndProductAvailability(String productName, String productAvailability);

}
