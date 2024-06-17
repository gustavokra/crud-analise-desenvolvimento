package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface AddressRepository {

    AddressBO create(AddressBO bo);

    AddressBO merge(AddressBO bo);

    List<AddressBO> returnAll();

    List<AddressBO> listAllBy(List<QueryFieldVO> queryField);
    
    AddressBO findFirstBy(List<QueryFieldVO> queryField);

    EnumDataBase getDataBase();

}
