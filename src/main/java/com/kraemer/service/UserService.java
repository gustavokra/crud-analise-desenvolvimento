package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.usecases.user.CreateUser;
import com.kraemer.domain.usecases.user.DisableUser;
import com.kraemer.domain.usecases.user.FindUserBy;
import com.kraemer.domain.usecases.user.FindAllUsers;
import com.kraemer.domain.usecases.user.FindUsersBy;
import com.kraemer.domain.usecases.user.UpdateUserInfo;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.domain.utils.exception.CrudException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService extends AbstractService {

    @Transactional
    public UserDTO create(UserDTO dto, EnumDataBase dbImpl) {
        var repository = repositoryFactory.getUserRepository(dbImpl);
        var createUser = new CreateUser(repository);

        return createUser.execute(dto);
    }

    public List<UserDTO> listAll(EnumDataBase dbImpl) {
        var repository = repositoryFactory.getUserRepository(dbImpl);
        var listAll = new FindAllUsers(repository);

        return listAll.execute(true);
    }

    public List<UserDTO> listBy(String document, EnumDataBase dbImpl) {

        if (StringUtil.isNullOrEmpty(document)) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "document");
        }

        var repository = repositoryFactory.getUserRepository(dbImpl);
        var findAllBy = new FindUsersBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("document", document);

        return findAllBy.execute(List.of(queryFieldUserId), true);
    }

    public UserDTO findBy(Long userId, EnumDataBase dbImpl) {

        if (userId == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "userId");
        }

        var repository = repositoryFactory.getUserRepository(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUserId = new QueryFieldInfoVO("id", userId);

        return findUserBy.execute(List.of(queryFieldUserId), true);
    }

    @Transactional
    public UserDTO updateInfo(UserDTO dto, Long userId, EnumDataBase dbImpl) {
        var repository = repositoryFactory.getUserRepository(dbImpl);
        var updateUserInfo = new UpdateUserInfo(repository);

        return updateUserInfo.execute(dto, userId);
    }

    @Transactional
    public UserDTO disable(Long userId, EnumDataBase dbImpl) {
        var repository = repositoryFactory.getUserRepository(dbImpl);
        var disableUser = new DisableUser(repository);

        return disableUser.execute(userId);
    }

    public UserDTO findByLogin(String username, String password, EnumDataBase dbImpl) {

        if (StringUtil.isNullOrEmpty(username)) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, username);
        }

        if (StringUtil.isNullOrEmpty(password)) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, password);
        }

        var repository = repositoryFactory.getUserRepository(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUsername = new QueryFieldInfoVO("username", username);
        var queryFieldPassword = new QueryFieldInfoVO("password", password);

        return findUserBy.execute(List.of(queryFieldUsername, queryFieldPassword), true);
    }

}
