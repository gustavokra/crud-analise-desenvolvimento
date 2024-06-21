package com.kraemer.domain.usecases.seller;

import java.util.List;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.SellerMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateSeller {

    private SellerRepository sellerRepository;

    public UpdateSeller(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerDTO execute(SellerDTO dto, Long id) {

        QueryFieldVO querField = new QueryFieldVO("id", id);

        SellerBO sellerFound = sellerRepository.findFirstBy(List.of(querField));

        if(sellerFound == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        sellerFound.handleUpdate(SellerMapper.toBO(dto));

        SellerBO sellerUpdated = sellerRepository.merge(sellerFound);

        return SellerMapper.toDTO(sellerUpdated);

    }

}
