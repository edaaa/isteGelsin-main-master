package com.example.demo.services.transfer;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.stocks.dto.StockResponse;
import org.modelmapper.internal.Pair;


public interface TransferService {

    boolean matches(DepoEntity fromDepo, DepoEntity toDepo);

    Pair<Boolean, StockResponse> validate(DepoEntity fromDepo, DepoEntity toDepo);

}
