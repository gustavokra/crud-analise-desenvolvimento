package com.kraemer.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.infra.database.mysql.mappers.MysqlAddressMapper;
import com.kraemer.infra.database.mysql.model.MysqlAddress;

public class MysqlAddressRepository implements IAddressRepository {

    @Override
    public AddressBO create(AddressBO bo) {
        MysqlAddress mysqlAddress = MysqlAddressMapper.toEntity(bo);
        mysqlAddress.persist();
        return MysqlAddressMapper.toDomain(mysqlAddress);
    }

    @Override
    public AddressBO merge(AddressBO bo) {
        MysqlAddress entity = MysqlAddressMapper.toEntity(bo);
        MysqlAddress.getEntityManager().merge(entity);
        return MysqlAddressMapper.toDomain(entity);
    }

    @Override
    public List<AddressBO> findAllBy(List<QueryFieldInfoVO> queryFieldInfos) {
        var params = ListUtil.stream(queryFieldInfos)
                        .filter(queryField -> queryField.getFieldValue() != null)
                        .collect(Collectors.toMap(
                            queryField -> StringUtil.replaceDot(queryField.getFieldName()),
                            QueryFieldInfoVO::getFieldValue));

        var query = new StringBuilder();

        ListUtil.stream(queryFieldInfos).forEach(queryField -> {
            var formatedFielValue = queryField.getFieldValue() != null 
            ? " = :".concat(StringUtil.replaceDot(queryField.getFieldName()))
            : " IS NULL";

            if(StringUtil.isNotNullOrEmpty(query.toString())) {
                query.append(queryField.getFieldName()).append(formatedFielValue);
            } else {
                query.append(" AND ").append(queryField.getFieldName()).append(formatedFielValue);
            }
        });

        return ListUtil.stream(MysqlAddress.list(query.toString(), params))
            .map(adress -> MysqlAddressMapper.toDomain((MysqlAddress) adress))
            .collect(Collectors.toList());
    }

    @Override
    public List<AddressBO> findAll() {
        return ListUtil.stream(MysqlAddress.listAll())
        .map(address -> MysqlAddressMapper.toDomain((MysqlAddress) address))
        .collect(Collectors.toList());
    }

    @Override
    public AddressBO findFirstBy(List<QueryFieldInfoVO> queryFieldInfo) {
        return ListUtil.first(null);
    }

    @Override
    public EnumDBImpl getType() {
        return EnumDBImpl.MYSQL;
    }
    
}
