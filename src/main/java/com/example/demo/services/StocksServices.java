package com.example.demo.services;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.products.entity.ProductEntity;
import com.example.demo.stocks.dto.StockResponse;
import com.example.demo.stocks.dto.StockSaveDto;
import com.example.demo.stocks.dto.StockTransferDto;
import com.example.demo.stocks.entity.StockEntity;

public interface StocksServices {
    StockResponse save(StockSaveDto stockSaveDto);

    StockResponse transfer(StockTransferDto stockTransferDto);

    void transfer(StockEntity fromDepoStockEntity, DepoEntity toDepoEntity, int count);
}
