package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;

public interface CrudRepository<T> {

    T create(T bo);

    T merge(T bo);

    List<T> findAll();

    List<T> findAllBy(List<QueryFieldInfoVO> queryFieldInfo);

    T findFirstBy(List<QueryFieldInfoVO> queryFieldInfo);

    EnumDataBase getType();

}
