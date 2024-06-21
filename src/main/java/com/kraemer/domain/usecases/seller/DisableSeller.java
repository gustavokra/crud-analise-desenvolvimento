package com.kraemer.domain.usecases.seller;

import java.util.List;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.SellerMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class DisableSeller {

    private SellerRepository sellerRepository;

    public DisableSeller(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerDTO execute(Long id) {

        QueryFieldVO queryField = new QueryFieldVO("id", id);

        SellerBO sellerFound = sellerRepository.findFirstBy(List.of(queryField));

        if (sellerFound == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        if (sellerFound.getDisabledAt() != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO);
        }

        sellerFound.handleDisable();

        sellerRepository.merge(sellerFound);

        return SellerMapper.toDTO(sellerFound);

    }

}
