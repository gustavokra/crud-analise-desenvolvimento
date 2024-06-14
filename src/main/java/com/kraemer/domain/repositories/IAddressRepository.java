package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;

public interface IAddressRepository {

    AddressBO create(AddressBO bo);

    AddressBO merge(AddressBO bo);

    List<AddressBO> findAllBy(List<QueryFieldInfoVO> queryFieldInfo);

    List<AddressBO> findAll();
    
    AddressBO findFirstBy(List<QueryFieldInfoVO> queryFieldInfo);

    EnumDBImpl getType();

}
