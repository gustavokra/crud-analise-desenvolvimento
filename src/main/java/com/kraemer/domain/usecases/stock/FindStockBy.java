package com.kraemer.domain.usecases.stock;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.StockMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.StockRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindStockBy {
    
    private StockRepository stockRepository;

    public FindStockBy(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO execute(List<QueryFieldVO> queryFields, boolean throwsException) {
        var stockFound = stockRepository.findFirstBy(queryFields);

        if(stockFound == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                        .map(QueryFieldVO::getFieldName)
                        .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return stockFound != null ? StockMapper.toDTO(stockFound) : null;
    }

}
