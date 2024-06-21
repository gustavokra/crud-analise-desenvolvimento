package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.StockBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface StockRepository {

    StockBO create(StockBO bo);

    StockBO merge(StockBO bo);

    List<StockBO> returnAll();

    StockBO findFirstBy(List<QueryFieldVO> queryFields);

    List<StockBO> listBy(List<QueryFieldVO> queryFields);

    EnumDataBase getDataBase();

}
