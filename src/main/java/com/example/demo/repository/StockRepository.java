package com.example.demo.repository;


import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.products.entity.ProductEntity;
import com.example.demo.stocks.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    Optional<StockEntity> findByDepoAndProduct(DepoEntity depoEntity, ProductEntity productEntity);

}
