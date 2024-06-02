package org.acme.infra.database.mysql.repositories;

import java.util.List;

import org.acme.domain.entities.UserBO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.repositories.IUserRepository;

public class PgUserRepository implements IUserRepository {

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
    public EnumDBImpl getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public List<UserBO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    
}
