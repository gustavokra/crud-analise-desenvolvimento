package com.kraemer.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.ProductBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.infra.database.mysql.mappers.MySqlProductMapper;
import com.kraemer.infra.database.mysql.model.MySqlProduct;

public class MySqlProductRepositoryImp implements ProductRepository {

    @Override
    public ProductBO create(ProductBO productBO) {
        MySqlProduct mySqlProduct = MySqlProductMapper.toEntity(productBO);
        mySqlProduct.persist();
        return MySqlProductMapper.toBO(mySqlProduct);
    }

    @Override
    public ProductBO merge(ProductBO productBO) {
        MySqlProduct mySqlAddress = MySqlProductMapper.toEntity(productBO);
        MySqlProduct.getEntityManager().merge(mySqlAddress);
        return MySqlProductMapper.toBO(mySqlAddress);
    }

    @Override
    public List<ProductBO> listBy(List<QueryFieldVO> queryFieldInfos) {
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

        return ListUtil.stream(MySqlProduct.list(query.toString(), queryParameters))
                .map(stockEntity -> MySqlProductMapper.toBO((MySqlProduct) stockEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductBO> returnAll() {
        return ListUtil.stream(MySqlProduct.listAll())
                .map(entityAddress -> MySqlProductMapper.toBO((MySqlProduct) entityAddress))
                .collect(Collectors.toList());
    }

    @Override
    public ProductBO findFirstBy(List<QueryFieldVO> queryFieldInfo) {
        return ListUtil.first(listBy(queryFieldInfo));
    }

    @Override
    public EnumDataBase getDataBase() {
        return EnumDataBase.MYSQL;
    }

}
