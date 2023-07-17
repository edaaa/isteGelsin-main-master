package com.example.demo.services.transfer;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.stocks.dto.StockResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.Pair;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@AllArgsConstructor
@Component
public class InterCityTransfer implements TransferService {

    private final MessageSource messageSource;

    @Override
    public boolean matches(DepoEntity fromDepo, DepoEntity toDepo) {
        return fromDepo.getCity() != toDepo.getCity();
    }

    //TODO sehirler arası gönderimler sadece ana depo üzerinden yapılabilmektedir.
    @Override
    public Pair<Boolean, StockResponse> validate(DepoEntity fromDepo, DepoEntity toDepo) {

        StockResponse stockResponse = new StockResponse(messageSource.getMessage("product.create.fail", null, Locale.ENGLISH));
        return Pair.of(true, stockResponse);
    }
}
