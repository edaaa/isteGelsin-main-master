package com.example.demo.stocks.dto;

import com.example.demo.depots.entity.DepoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockSaveDto {
    private int count;
    private Long depoId;
    private Long productId;
}
