package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.usecases.user.CreateUser;
import com.kraemer.domain.usecases.user.DisableUser;
import com.kraemer.domain.usecases.user.FindUserBy;
import com.kraemer.domain.usecases.user.FindAllUsers;
import com.kraemer.domain.usecases.user.FindUsersBy;
import com.kraemer.domain.usecases.user.UpdateUserInfo;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.domain.utils.exception.CrudException;
import com.kraemer.infra.database.mysql.repositories.MySqlUserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService extends AbstractService {

    @Inject
    MySqlUserRepository mySqlUserRepository;

    @Transactional
    public UserDTO create(UserDTO dto, EnumDBImpl dbImpl) {
        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var createUser = new CreateUser(repository);

        return createUser.execute(dto);
    }

    public List<UserDTO> listAll(EnumDBImpl dbImpl) {
        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var listAll = new FindAllUsers(repository);

        return listAll.execute(true);
    }

    public List<UserDTO> listBy(String document, EnumDBImpl dbImpl) {

        if (StringUtil.isNullOrEmpty(document)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "document");
        }

        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var findAllBy = new FindUsersBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("document", document);

        return findAllBy.execute(List.of(queryFieldUserId), true);
    }

    public UserDTO findBy(Long userId, EnumDBImpl dbImpl) {

        if (userId == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "userId");
        }

        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("id", userId);

        return findUserBy.execute(List.of(queryFieldUserId), true);
    }

    @Transactional
    public UserDTO updateInfo(UserDTO dto, Long userId, EnumDBImpl dbImpl) {
        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var updateUserInfo = new UpdateUserInfo(repository);

        return updateUserInfo.execute(dto, userId);
    }

    @Transactional
    public UserDTO disable(Long userId, EnumDBImpl dbImpl) {
        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var disableUser = new DisableUser(repository);

        return disableUser.execute(userId);
    }

    public UserDTO findByLogin(String username, String password, EnumDBImpl dbImpl) {

        if (StringUtil.isNullOrEmpty(username)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, username);
        }

        if (StringUtil.isNullOrEmpty(password)) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, password);
        }

        var repository = dbFactory.getUserRepoImpl(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUsername = new QueryFieldInfoVO("username", username);
        var queryFieldPassword = new QueryFieldInfoVO("password", password);

        return findUserBy.execute(List.of(queryFieldUsername, queryFieldPassword), true);
    }

}
