package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.StockRepository;
import com.kraemer.domain.usecases.stock.CreateStock;
import com.kraemer.domain.usecases.stock.DisableStock;
import com.kraemer.domain.usecases.stock.FindStockBy;
import com.kraemer.domain.usecases.stock.ReturnAllStocks;
import com.kraemer.domain.usecases.stock.UpdateStock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StockService extends AbstractService {

    @Transactional
    public StockDTO create(StockDTO dto, EnumDataBase dataBase) {
        StockRepository repository = stockRepositoryFactory.getRepository(dataBase);
        CreateStock createStock = new CreateStock(repository);
        return createStock.execute(dto);
    }

    public List<StockDTO> returnAll(EnumDataBase dataBase) {
        StockRepository repository = stockRepositoryFactory.getRepository(dataBase);
        var returnAll = new ReturnAllStocks(repository);
        return returnAll.execute();
    }

    public StockDTO findById(Long stockId, EnumDataBase dataBase) {
        StockRepository repository = stockRepositoryFactory.getRepository(null);
        var findStockBy = new FindStockBy(repository);
        QueryFieldVO queryField = new QueryFieldVO("id", stockId);
        return findStockBy.execute(List.of(queryField), true);
    }

    public StockDTO update(StockDTO dto, Long id, EnumDataBase dataBase) {
        StockRepository repository = stockRepositoryFactory.getRepository(dataBase);
        var updateStock = new UpdateStock(repository);
        return updateStock.execute(dto, id);
    }

    public StockDTO disable(Long id, EnumDataBase dataBase) {
        StockRepository repository = stockRepositoryFactory.getRepository(dataBase);
        var disableStock = new DisableStock(repository);
        return disableStock.execute(id);
    }

}
