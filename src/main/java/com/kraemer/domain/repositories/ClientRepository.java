package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.ClientBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface ClientRepository {
    
    ClientBO create(ClientBO clientBO);
    
    ClientBO merge(ClientBO clientBO);
    
    List<ClientBO> returnAll();
    
    ClientBO findFirstBy(List<QueryFieldVO> queryFields);
    
    List<ClientBO> listBy(List<QueryFieldVO> queryFields);

    EnumDataBase getDataBase();

}
