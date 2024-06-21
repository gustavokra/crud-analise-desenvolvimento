package com.kraemer.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.infra.database.mysql.mappers.MysqlUserMapper;
import com.kraemer.infra.database.mysql.model.MySqlUser;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MySqlUserRepositoryImp implements UserRepository {
    
    @Override
    public UserBO create(UserBO bo) {
        var panacheUser = MysqlUserMapper.toEntity(bo);

        panacheUser.persist();

        return MysqlUserMapper.toDomain(panacheUser);
    }

    @Override
    public List<UserBO> returnAll() {
        return ListUtil.stream(MySqlUser.listAll())
            .map(value -> MysqlUserMapper.toDomain(((MySqlUser) value)))
            .collect(Collectors.toList());
    }

    @Override
    public List<UserBO> listBy(List<QueryFieldVO> queryFieldsVO) {
        var params = ListUtil.stream(queryFieldsVO)
                .filter(item -> item.getFieldValue() != null)
                .collect(Collectors.toMap(
                        item -> StringUtil.replaceDot(item.getFieldName()),
                        QueryFieldVO::getFieldValue));

        var query = new StringBuilder();

        queryFieldsVO.stream().forEach(val -> {
            var formatedFieldName = val.getFieldValue() != null
                    ? " = :".concat(StringUtil.replaceDot(val.getFieldName()))
                    : " is NULL";

            if (StringUtil.isNullOrEmpty(query.toString())) {
                query.append(val.getFieldName().concat(formatedFieldName));
            } else {
                query.append(" AND ".concat(val.getFieldName().concat(formatedFieldName)));
            }
        });

        return ListUtil.stream(MySqlUser.list(query.toString(), params))
                .map(value -> MysqlUserMapper.toDomain(((MySqlUser) value)))
                .collect(Collectors.toList());
    }

    @Override
    public UserBO findBy(List<QueryFieldVO> queryFieldsVO) {
        return ListUtil.first(listBy(queryFieldsVO));
    }

    @Override
    public UserBO merge(UserBO bo) {
        var entity = MysqlUserMapper.toEntity(bo);

        MySqlUser.getEntityManager().merge(entity);

        return bo;
    }

    @Override
    public EnumDataBase getDataBase() {
        return EnumDataBase.MYSQL;
    }

}
