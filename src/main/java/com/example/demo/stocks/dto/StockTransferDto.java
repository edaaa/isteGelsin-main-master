package com.example.demo.stocks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockTransferDto {
    private int count;
    private Long fromDepoId;
    private Long toDepoId;
    private Long productId;
}
