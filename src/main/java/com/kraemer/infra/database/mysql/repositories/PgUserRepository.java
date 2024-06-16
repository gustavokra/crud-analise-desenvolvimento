package com.kraemer.infra.database.mysql.repositories;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.UserRepository;

public class PgUserRepository implements UserRepository {

    @Override
    public UserBO create(UserBO bo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserBO merge(UserBO bo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'merge'");
    }

    @Override
    public List<UserBO> findAllBy(List<QueryFieldInfoVO> queryFieldInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBy'");
    }

    @Override
    public UserBO findFirstBy(List<QueryFieldInfoVO> queryFieldInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFirstBy'");
    }

    @Override
    public EnumDataBase getDataBase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public List<UserBO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    
}
