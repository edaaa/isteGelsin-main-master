package com.example.demo.controller;

import com.example.demo.services.StocksServices;
import com.example.demo.stocks.dto.StockResponse;
import com.example.demo.stocks.dto.StockSaveDto;
import com.example.demo.stocks.dto.StockTransferDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@AllArgsConstructor
public class StockController {
    private final  StocksServices stocksServices; //isim coğul yapma

    @PostMapping(value = "/stock", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("stock kaydetme işlemi gerçekleştirilir")
    public ResponseEntity<StockResponse> addStock(@RequestBody StockSaveDto stockSaveDto) {
        return new ResponseEntity<>( stocksServices.save(stockSaveDto), HttpStatus.OK);
    }

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("stock transfer işlemi gerçekleştirilir")
    public ResponseEntity<StockResponse> transferStock(@RequestBody StockTransferDto stockTransferDto) {
        return new ResponseEntity<>( stocksServices.transfer(stockTransferDto), HttpStatus.OK);

    }

}
