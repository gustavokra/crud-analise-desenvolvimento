package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.UnitMeasureBO;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface UnitMeasureRepository {
    
    UnitMeasureBO create(UnitMeasureBO bo);

    UnitMeasureBO merge(UnitMeasureBO bo);

    List<UnitMeasureBO> returnAll();

    UnitMeasureBO findFirstBy(List<QueryFieldVO> fields);

    List<UnitMeasureBO> listBy(List<QueryFieldVO> fields);

}
