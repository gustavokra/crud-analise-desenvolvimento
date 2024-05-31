package org.acme.infra.database.mysql.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.domain.entities.UserBO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.repositories.IUserRepository;
import org.acme.domain.utils.ListUtil;
import org.acme.domain.utils.StringUtil;
import org.acme.infra.database.mysql.mappers.MYSQLUserMapper;
import org.acme.infra.database.mysql.model.MySqlUser;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MySqlUserRepository implements IUserRepository {
    @Override
    public UserBO create(UserBO bo) {
        var panacheUser = MYSQLUserMapper.toEntity(bo);

        panacheUser.persist();

        return MYSQLUserMapper.toDomain(panacheUser);
    }

    @Override
    public UserBO merge(UserBO bo) {
        var entity = MYSQLUserMapper.toEntity(bo);

        MySqlUser.getEntityManager().merge(entity);

        return bo;
    }

    @Override
    public UserBO findFirstBy(List<QueryFieldInfoVO> queryFieldsInfoVO) {
        return ListUtil.first(findAllBy(queryFieldsInfoVO));
    }

    @Override
    public List<UserBO> findAllBy(List<QueryFieldInfoVO> queryFieldsInfoVO) {
        var params = ListUtil.stream(queryFieldsInfoVO)
                .filter(item -> item.getFieldValue() != null)
                .collect(Collectors.toMap(
                        item -> StringUtil.replaceDot(item.getFieldName()),
                        QueryFieldInfoVO::getFieldValue));

        var query = new StringBuilder();

        queryFieldsInfoVO.stream().forEach(val -> {
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
                .map(value -> MYSQLUserMapper.toDomain(((MySqlUser) value)))
                .collect(Collectors.toList());
    }

    @Override
    public EnumDBImpl getType() {
        return EnumDBImpl.MYSQL;
    }

}
