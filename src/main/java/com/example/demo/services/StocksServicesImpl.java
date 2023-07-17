package com.example.demo.services;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.depots.entity.DepoType;
import com.example.demo.products.entity.ProductEntity;
import com.example.demo.repository.DepoRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.services.transfer.TransferService;
import com.example.demo.stocks.dto.StockResponse;
import com.example.demo.stocks.dto.StockSaveDto;
import com.example.demo.stocks.dto.StockTransferDto;
import com.example.demo.stocks.entity.StockEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.Pair;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StocksServicesImpl implements StocksServices {

    private final StockRepository stockRepository;
    private final DepoRepository depoRepository;
    private final ProductRepository productRepository;

    private final MessageSource messageSource;

    private final List<TransferService> transferServices;

    @Override
    public StockResponse save(StockSaveDto stockSaveDto) {
        final Optional<DepoEntity> depoEntity = depoRepository.findById(stockSaveDto.getDepoId());
        if (depoEntity.isEmpty()) {
            return new StockResponse(messageSource.getMessage("stock.is.empty", null, Locale.ENGLISH));
        } else if (depoEntity.get().getDepoType() != DepoType.MAIN) {
            return new StockResponse(messageSource.getMessage("stock.not.type.main", null, Locale.ENGLISH));
        }
        Optional<ProductEntity> productEntity = productRepository.findById(stockSaveDto.getProductId());
        if (productEntity.isEmpty()) {
            return new StockResponse(messageSource.getMessage("stock.fail.not.found.product", null, Locale.ENGLISH));
        }
        StockEntity stockEntity = new StockEntity();
        stockEntity.setDepo(depoEntity.get());
        stockEntity.setCount(stockSaveDto.getCount());
        stockEntity.setProduct(productEntity.get());
        stockRepository.save(stockEntity);
        return new StockResponse(messageSource.getMessage("stock.add.success", null, Locale.ENGLISH));

    }

    @Override
    public StockResponse transfer(StockTransferDto stockTransferDto) {
        Optional<DepoEntity> toDepoEntity = depoRepository.findById(stockTransferDto.getToDepoId());
        Optional<DepoEntity> fromDepoEntity = depoRepository.findById(stockTransferDto.getFromDepoId());
        Optional<ProductEntity> productEntity = productRepository.findById(stockTransferDto.getProductId());
        if (toDepoEntity.isEmpty() || fromDepoEntity.isEmpty() || productEntity.isEmpty()) {
            return new StockResponse(messageSource.getMessage("stock.transfer.fail", null, Locale.ENGLISH));
        }
        Pair<Boolean, StockResponse> validateResult = transferServices.stream()
                .filter(transfer -> transfer.matches(fromDepoEntity.get(), toDepoEntity.get()))
                .findFirst()
                .orElseThrow()
                .validate(fromDepoEntity.get(), toDepoEntity.get());

        if (!validateResult.getLeft()) {
            return validateResult.getRight();
        }
        Optional<StockEntity> fromDepoStockEntityOptinal = stockRepository.findByDepoAndProduct(fromDepoEntity.get(), productEntity.get());

        if (fromDepoStockEntityOptinal.isEmpty()) {//todo bu depode bu urun yok
            return new StockResponse(messageSource.getMessage("stock.transfer.not.found.product", null, Locale.ENGLISH));
        } else if (stockTransferDto.getCount() > fromDepoStockEntityOptinal.get().getCount()) {
            //todo depoda ürün yeterli sayıda bulunmamaktadır
            return new StockResponse(messageSource.getMessage("stock.transfer.not.count.product", null, Locale.ENGLISH));
        }

        transfer(fromDepoStockEntityOptinal.get(), toDepoEntity.get(), stockTransferDto.getCount());
        return new StockResponse(messageSource.getMessage("stock.transfer.success", null, Locale.ENGLISH));

    }

    @Override
    public void transfer(StockEntity fromDepoStockEntity, DepoEntity toDepoEntity, int count) {
        Optional<StockEntity> toDepoStockEntityOptinal = stockRepository.findByDepoAndProduct(toDepoEntity, fromDepoStockEntity.getProduct());
        fromDepoStockEntity.setCount(fromDepoStockEntity.getCount() - count);

        StockEntity toStockEntity = toDepoStockEntityOptinal.orElse(getNewStockEntity(toDepoEntity, fromDepoStockEntity.getProduct()));
        toStockEntity.setCount(toStockEntity.getCount()+ count);
        stockRepository.saveAll(Arrays.asList(toStockEntity,fromDepoStockEntity));
    }

    private StockEntity getNewStockEntity(DepoEntity depoEntity, ProductEntity productEntity) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setDepo(depoEntity);
        stockEntity.setProduct(productEntity);
        stockEntity.setCount(0);
        return stockEntity;

    }
}
