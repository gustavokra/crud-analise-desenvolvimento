package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;

public interface UserRepository {
    
    UserBO create(UserBO bo);

    UserBO merge(UserBO bo);

    List<UserBO> findAll();

    List<UserBO> findAllBy(List<QueryFieldInfoVO> queryFieldInfo);
    
    UserBO findFirstBy(List<QueryFieldInfoVO> queryFieldInfo);

    EnumDataBase getDataBase();

}
