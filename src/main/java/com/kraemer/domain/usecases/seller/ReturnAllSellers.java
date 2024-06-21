package com.kraemer.domain.usecases.seller;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.mappers.SellerMapper;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.utils.ListUtil;

public class ReturnAllSellers {

    private SellerRepository sellerRepository;

    public ReturnAllSellers(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<SellerDTO> execute() {
        List<SellerBO> sellers = sellerRepository.returnAll();

        return ListUtil.stream(sellers)
                .map(SellerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
