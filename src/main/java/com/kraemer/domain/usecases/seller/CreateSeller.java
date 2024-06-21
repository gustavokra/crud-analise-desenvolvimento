package com.kraemer.domain.usecases.seller;


import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.mappers.SellerMapper;
import com.kraemer.domain.repositories.SellerRepository;

public class CreateSeller {

    private SellerRepository sellerRepository;

    public CreateSeller(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerDTO execute(SellerDTO dto) {
        SellerBO createdSeller = sellerRepository.create(SellerMapper.toBO(dto));
        return SellerMapper.toDTO(createdSeller);
    }

}
