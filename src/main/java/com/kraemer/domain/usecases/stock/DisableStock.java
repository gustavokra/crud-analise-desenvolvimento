package com.kraemer.domain.usecases.stock;

import java.util.List;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.mappers.StockMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.StockRepository;

public class DisableStock {
    
    private StockRepository stockRepository;

    public DisableStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO execute(Long id) {
        QueryFieldVO field = new QueryFieldVO("id", id);
        
        var stockFound = stockRepository.findFirstBy(List.of(field));

        stockFound.handleDisable();

        stockRepository.merge(stockFound);

        return StockMapper.toDTO(stockFound);
    }
}
