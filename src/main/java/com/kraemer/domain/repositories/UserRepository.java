package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface UserRepository {
    
    UserBO create(UserBO bo);

    UserBO merge(UserBO bo);

    List<UserBO> returnAll();

    List<UserBO> listBy(List<QueryFieldVO> queryField);
    
    UserBO findFirstBy(List<QueryFieldVO> queryField);

    EnumDataBase getDataBase();

}
