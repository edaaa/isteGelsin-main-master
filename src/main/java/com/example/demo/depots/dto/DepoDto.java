package com.example.demo.depots.dto;

import com.example.demo.depots.entity.DepoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepoDto {

    private String name;
    private DepoType depoType;
    private int city;
    private Double locationLat;
    private Double locationLong;
    private boolean status;
    private String cost_center;

}
