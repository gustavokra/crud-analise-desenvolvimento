package com.kraemer.infra.database.mysql.repositories;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
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
    public List<UserBO> returnAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnAll'");
    }

    @Override
    public List<UserBO> listAllBy(List<QueryFieldVO> queryFieldInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllFilterBy'");
    }

    @Override
    public UserBO findBy(List<QueryFieldVO> queryFieldInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFilterBy'");
    }

    @Override
    public EnumDataBase getDataBase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataBase'");
    }

    
}
