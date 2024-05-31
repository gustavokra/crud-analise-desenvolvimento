package org.acme.service;

import java.util.List;

import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.usecases.FindUserBy;
import org.acme.domain.utils.exception.CrudException;
import org.acme.infra.database.mysql.model.MySqlUser;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService extends AbstractService {

    public UserDTO findBy(Long userId, EnumDBImpl dbImpl) {

        if (userId == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "userId");
        }

        var repository = dbFactory.getImpl(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("id", 1);

        var teste = MySqlUser.findById(userId);

        System.out.println(teste);

        return findUserBy.execute(List.of(queryFieldUserId), true);
    }

}
