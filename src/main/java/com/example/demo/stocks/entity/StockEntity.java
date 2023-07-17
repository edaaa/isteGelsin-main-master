package com.example.demo.stocks.entity;
import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.products.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
public class StockEntity {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_depo")
    private DepoEntity depo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_product")
    private ProductEntity product;

    private int count;






}
///bir ürün entity olustur
//create depo kontrol et kullanıcıdan depo type al eger main gönderirse hata ver main sadece bir tane olsn
//kullanıcı urun olusturacak
//ürün ile depo arasında 3 tablo olustur one to many stok bilgisi ekle depo entity ve product entity ile
//sadece main depoya stock eklenebilir stok eklenirken depo id ile depo cekilir main değilse hata verilir değilse eklenir

