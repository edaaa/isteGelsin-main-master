package com.example.demo.services;

import com.example.demo.depots.dto.DepoCloseDto;
import com.example.demo.depots.dto.DepoCreateDto;
import com.example.demo.depots.dto.DepoDto;
import com.example.demo.depots.dto.DepoResponse;
import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.depots.entity.DepoType;
import com.example.demo.repository.DepoRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.stocks.entity.StockEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepoServicesImpl implements DepoServices {

    private final DepoRepository depoRepository;
    private final StockRepository stockRepository;
    private final MessageSource messageSource;
    private final StocksServices stocksServices;

    @Override
    public DepoResponse save(DepoDto depoDto) {
        if (depoDto.getDepoType() == DepoType.MAIN) {
            Optional<DepoEntity> depo = depoRepository.findByDepoType(depoDto.getDepoType());
            if (depo.isPresent()) {
                return new DepoResponse(messageSource.getMessage("depo.create.fail", null, Locale.ENGLISH));
            }
        }
        ModelMapper modelMapper = new ModelMapper();
        DepoEntity depoEntity = modelMapper.map(depoDto, DepoEntity.class);
        depoRepository.save(depoEntity);
        return new DepoResponse(messageSource.getMessage("depo.create.success", null, Locale.ENGLISH));
    }

    @Override
    public DepoResponse closeDepo(DepoCloseDto depoCloseDto) {
        Optional<DepoEntity> depoEntity = depoRepository.findById(depoCloseDto.getDepoId());
        Optional<DepoEntity> depoMain = depoRepository.findByDepoType(DepoType.MAIN);
        if (depoEntity.isEmpty() || depoMain.isEmpty()) {
            return new DepoResponse(messageSource.getMessage("depo.close.not.found.depo", null, Locale.ENGLISH));
        }

       List<StockEntity> stocks = depoEntity.get().getStocks();
        for (StockEntity stock : stocks) {
            stocksServices.transfer(stock,depoMain.get(),stock.getCount());
        }
        depoEntity.get().setStatus(false);
        depoRepository.save(depoEntity.get());

        return new DepoResponse(messageSource.getMessage("depo.close.success", null, Locale.ENGLISH));
    }
}
