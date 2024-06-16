package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;

public interface AddressRepository {

    AddressBO create(AddressBO bo);

    AddressBO merge(AddressBO bo);

    List<AddressBO> returnAllFilterBy(List<QueryFieldInfoVO> queryFieldInfo);

    List<AddressBO> returnAll();
    
    AddressBO returnFirstBy(List<QueryFieldInfoVO> queryFieldInfo);

    EnumDataBase getDataBase();

}
