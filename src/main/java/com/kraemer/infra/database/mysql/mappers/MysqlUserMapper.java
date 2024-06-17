package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.vo.CreationDateVO;
import com.kraemer.infra.database.mysql.model.MySqlUser;

public class MysqlUserMapper {

    public static UserBO toDomain(MySqlUser entity) {
        var bo = new UserBO(
                entity.getId(),
                entity.getDocument(),
                entity.getName(),
                entity.getUsername(),
                entity.getPassword(),
                new CreationDateVO(entity.getCreatedAt()),
                entity.getUpdatedAt(),
                entity.getDisabledAt());

        return bo;
    }

    public static MySqlUser toEntity(UserBO bo) {
        var panacheUser = new MySqlUser();

        panacheUser.setId(bo.getId());
        panacheUser.setDocument(bo.getDocument());
        panacheUser.setName(bo.getName());
        panacheUser.setUsername(bo.getUsername());
        panacheUser.setPassword(bo.getPassword());
        panacheUser.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt().getValue() : null);
        panacheUser.setUpdatedAt(bo.getUpdatedAt());
        panacheUser.setDisabledAt(bo.getDisabledAt());

        return panacheUser;
    }

}
