package org.acme.domain.repositories;

import java.util.List;

import org.acme.domain.entities.UserBO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.vo.QueryFieldInfoVO;

public interface IUserRepository {
    
    UserBO create(UserBO bo);

    UserBO merge(UserBO bo);

    List<UserBO> findAllBy(List<QueryFieldInfoVO> queryFieldInfo);

    List<UserBO> findAll();
    
    UserBO findFirstBy(List<QueryFieldInfoVO> queryFieldInfo);

    EnumDBImpl getType();

}
