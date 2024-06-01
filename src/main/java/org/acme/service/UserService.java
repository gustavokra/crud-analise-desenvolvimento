package org.acme.service;

import java.util.List;

import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.usecases.CreateUser;
import org.acme.domain.usecases.DisableUser;
import org.acme.domain.usecases.FindUserBy;
import org.acme.domain.usecases.ListUsersBy;
import org.acme.domain.usecases.UpdateUserInfo;
import org.acme.domain.utils.StringUtil;
import org.acme.domain.utils.Utils;
import org.acme.domain.utils.exception.CrudException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService extends AbstractService {

    public UserDTO findByLogin(String username, String password, EnumDBImpl dbImpl) {

        if (StringUtil.isNullOrEmpty(username)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, username);
        }

        if (StringUtil.isNullOrEmpty(password)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, password);
        }

        var repository = dbFactory.getImpl(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUsername = new QueryFieldInfoVO("username", username);
        var queryFieldPassword = new QueryFieldInfoVO("password", password);

        return findUserBy.execute(List.of(queryFieldUsername, queryFieldPassword), true);
    }

    public UserDTO findBy(Long userId, EnumDBImpl dbImpl) {

        if (userId == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "userId");
        }

        var repository = dbFactory.getImpl(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("id", userId);

        return findUserBy.execute(List.of(queryFieldUserId), true);
    }

    @Transactional
    public UserDTO create(UserDTO dto, EnumDBImpl dbImpl) {
        var repository = dbFactory.getImpl(dbImpl);
        var createUser = new CreateUser(repository);

        return createUser.execute(dto);
    }

    @Transactional
    public UserDTO updateInfo(UserDTO dto, Long userId, EnumDBImpl dbImpl) {
        var repository = dbFactory.getImpl(dbImpl);
        var updateUserInfo = new UpdateUserInfo(repository);

        return updateUserInfo.execute(dto, userId);
    }

    @Transactional
    public UserDTO disable(Long userId, EnumDBImpl dbImpl) {
        var repository = dbFactory.getImpl(dbImpl);
        var disableUser = new DisableUser(repository);

        return disableUser.execute(userId);
    }

    public List<UserDTO> listBy(String document, EnumDBImpl dbImpl) {

        if (StringUtil.isNullOrEmpty(document)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "document");
        }

        var repository = dbFactory.getImpl(dbImpl);
        var findAllBy = new ListUsersBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("document", document);

        return findAllBy.execute(List.of(queryFieldUserId), true);
    }

}
