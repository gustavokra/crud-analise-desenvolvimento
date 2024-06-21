package com.kraemer.domain.usecases.stock;

import java.util.List;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.mappers.StockMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.StockRepository;

public class UpdateStock {
    
    private StockRepository stockRepository;

    public UpdateStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO execute(StockDTO dto, Long id) {

        QueryFieldVO queryFieldId = new QueryFieldVO("id", id);

        var existingStock = stockRepository.findFirstBy(List.of(queryFieldId));

        existingStock.handleUpdate(StockMapper.toBO(dto));

        stockRepository.merge(existingStock);

        return StockMapper.toDTO(existingStock);
        
    }
}
