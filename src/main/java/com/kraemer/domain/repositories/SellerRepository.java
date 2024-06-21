package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface SellerRepository {
    
    SellerBO create(SellerBO sellerBO);
    
    SellerBO merge(SellerBO sellerBO);
    
    List<SellerBO> returnAll();
    
    SellerBO findFirstBy(List<QueryFieldVO> queryFields);
    
    List<SellerBO> listBy(List<QueryFieldVO> queryFields);

    EnumDataBase getDataBase();

}
