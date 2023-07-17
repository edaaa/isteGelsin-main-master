package com.example.demo.depots.entity;
import com.example.demo.products.entity.ProductEntity;
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
public class DepoEntity {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    private String name;
    private DepoType depoType ;
    private int city;
    private Double locationLat;
    private Double locationLong;
    private boolean status;
    private  String cost_center;
    @OneToMany(mappedBy = "depo",  fetch = FetchType.LAZY)
    private List<StockEntity> stocks ;






}
///bir ürün entity olustur
//create depo kontrol et kullanıcıdan depo type al eger main gönderirse hata ver main sadece bir tane olsn
//kullanıcı urun olusturacak
//ürün ile depo arasında 3 tablo olustur one to many stok bilgisi ekle depo entity ve product entity ile
//sadece main depoya stock eklenebilir stok eklenirken depo id ile depo cekilir main değilse hata verilir değilse eklenir

