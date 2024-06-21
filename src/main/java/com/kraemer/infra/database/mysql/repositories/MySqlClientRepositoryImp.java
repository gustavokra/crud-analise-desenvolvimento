package com.kraemer.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.ClientBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ClientRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.infra.database.mysql.mappers.MySqlClientMapper;
import com.kraemer.infra.database.mysql.model.MySqlClient;

public class MySqlClientRepositoryImp implements ClientRepository {
    @Override
    public ClientBO create(ClientBO clientBO) {
        MySqlClient mysqlClient = MySqlClientMapper.toEntity(clientBO);
        mysqlClient.persist();
        return MySqlClientMapper.toBO(mysqlClient);
    }

    @Override
    public ClientBO merge(ClientBO clientBO) {
        MySqlClient mysqlClient = MySqlClientMapper.toEntity(clientBO);
        MySqlClient.getEntityManager().merge(mysqlClient);
        return MySqlClientMapper.toBO(mysqlClient);
    }

    @Override
    public List<ClientBO> listBy(List<QueryFieldVO> queryFieldInfos) {
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

        return ListUtil.stream(MySqlClient.list(query.toString(), queryParameters))
                .map(entityAddress -> MySqlClientMapper.toBO((MySqlClient) entityAddress))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientBO> returnAll() {
        return ListUtil.stream(MySqlClient.listAll())
                .map(entityAddress -> MySqlClientMapper.toBO((MySqlClient) entityAddress))
                .collect(Collectors.toList());
    }

    @Override
    public ClientBO findFirstBy(List<QueryFieldVO> queryFieldInfo) {
        return ListUtil.first(listBy(queryFieldInfo));
    }

    @Override
    public EnumDataBase getDataBase() {
        return EnumDataBase.MYSQL;
    }
}
