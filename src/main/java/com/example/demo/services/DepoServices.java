package com.example.demo.services;

import com.example.demo.depots.dto.DepoCloseDto;
import com.example.demo.depots.dto.DepoCreateDto;
import com.example.demo.depots.dto.DepoDto;
import com.example.demo.depots.dto.DepoResponse;
import org.springframework.stereotype.Service;

@Service
public interface DepoServices {

    public DepoResponse save(DepoDto depoDto);

    DepoResponse closeDepo(DepoCloseDto depoCloseDto);
}
