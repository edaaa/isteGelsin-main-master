package com.example.demo.services.transfer;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.repository.StockRepository;
import com.example.demo.stocks.dto.StockResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.Pair;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static org.apache.lucene.util.SloppyMath.*;

@AllArgsConstructor
@Component
public class InnerCityTransfer implements TransferService {

    private static final int MAX_TRANSFER_DISTANCE = 100 * 1000;

    private MessageSource messageSource;
    private StockRepository stockRepository;

    @Override
    public boolean matches(DepoEntity fromDepo, DepoEntity toDepo) {

        return fromDepo.getCity() == toDepo.getCity();
    }

    @Override
    public Pair<Boolean, StockResponse> validate(DepoEntity fromDepo, DepoEntity toDepo) {
        double dist = haversinMeters(fromDepo.getLocationLat(),
                fromDepo.getLocationLong(),
                toDepo.getLocationLat(),
                toDepo.getLocationLong());

        if (dist > MAX_TRANSFER_DISTANCE) {
            StockResponse response = new StockResponse(messageSource.getMessage("product.create.fail", null, Locale.ENGLISH));
            return Pair.of(false, response);
        }
        return Pair.of(true, null);

    }
}
