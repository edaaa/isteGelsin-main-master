package com.example.demo.services.transfer;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.depots.entity.DepoType;
import com.example.demo.stocks.dto.StockResponse;
import com.example.demo.stocks.entity.StockEntity;
import lombok.AllArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.modelmapper.internal.Pair;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class MainTransfer implements TransferService {


    @Override
    public boolean matches(DepoEntity fromDepo, DepoEntity toDepo) {
        return fromDepo.getDepoType() == DepoType.MAIN || toDepo.getDepoType() == DepoType.MAIN;
    }

    @Override
    public Pair<Boolean, StockResponse> validate(DepoEntity fromDepo, DepoEntity toDepo) {
        return Pair.of(true, null);
    }
}
