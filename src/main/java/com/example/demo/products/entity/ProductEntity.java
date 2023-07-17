package com.example.demo.products.entity;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.depots.entity.DepoType;
import com.example.demo.stocks.entity.StockEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Data
@NoArgsConstructor
@Table
public class ProductEntity {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    private String name;
    private String sku;
    private String barcode;
    private ProductType type;
    private boolean frozen;
    private Double price;
    private String unitType;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<StockEntity>  stocks;

}
