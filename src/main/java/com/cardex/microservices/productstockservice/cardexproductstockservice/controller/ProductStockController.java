package com.cardex.microservices.productstockservice.cardexproductstockservice.controller;

import com.cardex.microservices.productstockservice.cardexproductstockservice.beans.ProductStockBean;
import com.cardex.microservices.productstockservice.cardexproductstockservice.entity.ProductStock;
import com.cardex.microservices.productstockservice.cardexproductstockservice.entity.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStockController {

@Autowired
    Environment environment;

@Autowired
    ProductStockRepository repository;

@GetMapping("/check-product-stock/productName/{}/productAvailability/{productAvailability}")
public ProductStockBean checkProductStock(@PathVariable String productName,
                                          @PathVariable String productAvailability)
{

    ProductStock productStock=repository.findByProductNamendProductAvailability(productName,productAvailability);

    ProductStockBean productStockBean= new ProductStockBean(
            productStock.getId(),
            productStock.getProductName(),
            productStock.getProductPrice(),
            productStock.getProductAvailability(),
            productStock.getDiscountOffer(),
            Integer.parseInt(environment.getProperty("local.server.port"))
    );

    return productStockBean;

}




}
