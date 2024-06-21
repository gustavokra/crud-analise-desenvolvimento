package com.kraemer.domain.usecases.stock;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.mappers.StockMapper;
import com.kraemer.domain.repositories.StockRepository;

public class CreateStock {

    private StockRepository stockRepository;

    public CreateStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO execute(StockDTO dto) {
        var stockBO = StockMapper.toBO(dto);
        stockBO = stockRepository.create(stockBO);
        return StockMapper.toDTO(stockBO);
    }

}
