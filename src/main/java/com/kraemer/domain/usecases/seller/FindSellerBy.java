package com.kraemer.domain.usecases.seller;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.SellerMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindSellerBy {

    private SellerRepository sellerRepository;

    public FindSellerBy(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerDTO execute(List<QueryFieldVO> queryFields, boolean throwsException) {

        SellerBO sellerFound = sellerRepository.findFirstBy(queryFields);

        if (sellerFound == null && throwsException) {
            String fieldNames = ListUtil.stream(queryFields)
                    .map(QueryFieldVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fieldNames);
        }

        return sellerFound != null ? SellerMapper.toDTO(sellerFound) : null;

    }

}
