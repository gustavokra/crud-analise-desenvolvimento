package com.kraemer.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.StockBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.StockRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.infra.database.mysql.mappers.MySqlStockMapper;
import com.kraemer.infra.database.mysql.model.MySqlStock;

public class MySqlStockRepositoryImp implements StockRepository {
    @Override
    public StockBO create(StockBO stockBO) {
        MySqlStock mySqlStock = MySqlStockMapper.toEntity(stockBO);
        mySqlStock.persist();
        return MySqlStockMapper.toBO(mySqlStock);
    }

    @Override
    public StockBO merge(StockBO stockBO) {
        MySqlStock mySqlAddress = MySqlStockMapper.toEntity(stockBO);
        MySqlStock.getEntityManager().merge(mySqlAddress);
        return MySqlStockMapper.toBO(mySqlAddress);
    }

    @Override
    public List<StockBO> listBy(List<QueryFieldVO> queryFieldInfos) {
        var queryParameters = ListUtil.stream(queryFieldInfos)
                .filter(queryField -> queryField.getFieldValue() != null)
                .collect(Collectors.toMap(
                        queryField -> StringUtil.replaceDot(queryField.getFieldName()),
                        QueryFieldVO::getFieldValue));

        var query = new StringBuilder();

        ListUtil.stream(queryFieldInfos).forEach(queryField -> {
            String formatedFielValue = queryField.getFieldValue() != null
                    ? " = :".concat(StringUtil.replaceDot(queryField.getFieldName()))
                    : " IS NULL";

            if (StringUtil.isNullOrEmpty(query.toString())) {
                query.append(queryField.getFieldName()).append(formatedFielValue);
            } else {
                query.append(" AND ").append(queryField.getFieldName()).append(formatedFielValue);
            }
        });

        return ListUtil.stream(MySqlStock.list(query.toString(), queryParameters))
                .map(stockEntity -> MySqlStockMapper.toBO((MySqlStock) stockEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<StockBO> returnAll() {
        return ListUtil.stream(MySqlStock.listAll())
                .map(entityAddress -> MySqlStockMapper.toBO((MySqlStock) entityAddress))
                .collect(Collectors.toList());
    }

    @Override
    public StockBO findFirstBy(List<QueryFieldVO> queryFieldInfo) {
        return ListUtil.first(listBy(queryFieldInfo));
    }

    @Override
    public EnumDataBase getDataBase() {
        return EnumDataBase.MYSQL;
    }
}
