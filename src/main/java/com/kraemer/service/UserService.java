package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.usecases.user.CreateUser;
import com.kraemer.domain.usecases.user.DisableUser;
import com.kraemer.domain.usecases.user.FindUserBy;
import com.kraemer.domain.usecases.user.ReturnAllUsers;
import com.kraemer.domain.usecases.user.ListUsersBy;
import com.kraemer.domain.usecases.user.UpdateUser;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.domain.utils.exception.CrudException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService extends AbstractService {

    @Transactional
    public UserDTO create(UserDTO dto, EnumDataBase dbImpl) {
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var createUser = new CreateUser(repository);
        return createUser.execute(dto);
    }

    public List<UserDTO> returnAll(EnumDataBase dbImpl) {
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var returnAll = new ReturnAllUsers(repository);
        return returnAll.execute(true);
    }

    public List<UserDTO> listByDocument(String document, EnumDataBase dbImpl) {
        if (StringUtil.isNullOrEmpty(document)) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "document");
        }
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var findAllBy = new ListUsersBy(repository);
        var queryFieldUserId = new QueryFieldVO("document", document);
        return findAllBy.execute(List.of(queryFieldUserId), true);
    }

    public UserDTO findById(Long userId, EnumDataBase dbImpl) {
        if (userId == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "userId");
        }
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUserId = new QueryFieldVO("id", userId);
        return findUserBy.execute(List.of(queryFieldUserId), true);
    }

    @Transactional
    public UserDTO update(UserDTO dto, Long userId, EnumDataBase dbImpl) {
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var updateUserInfo = new UpdateUser(repository);
        return updateUserInfo.execute(dto, userId);
    }

    @Transactional
    public UserDTO disable(Long userId, EnumDataBase dbImpl) {
        var repository = userRepositoryFactory.getRepository(dbImpl);
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
        var repository = userRepositoryFactory.getRepository(dbImpl);
        var findUserBy = new FindUserBy(repository);
        var queryFieldUsername = new QueryFieldVO("username", username);
        var queryFieldPassword = new QueryFieldVO("password", password);
        return findUserBy.execute(List.of(queryFieldUsername, queryFieldPassword), true);
    }

}
