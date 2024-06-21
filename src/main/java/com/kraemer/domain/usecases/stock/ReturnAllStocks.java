package com.kraemer.domain.usecases.stock;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.mappers.StockMapper;
import com.kraemer.domain.repositories.StockRepository;
import com.kraemer.domain.utils.ListUtil;

public class ReturnAllStocks {
    
    private StockRepository stockRepository;

    public ReturnAllStocks(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockDTO> execute() {
        return ListUtil.stream(stockRepository.returnAll())
                    .map(stock -> StockMapper.toDTO(stock))
                    .collect(Collectors.toList());
    }

}
