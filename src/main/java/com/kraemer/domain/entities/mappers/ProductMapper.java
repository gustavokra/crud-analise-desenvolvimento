package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.ProductBO;
import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class ProductMapper {

    public static ProductBO toBO(ProductDTO dto) {
        return new ProductBO(
                dto.getId(),
                StockMapper.toBO(dto.getStockDTO()),
                dto.getDescription(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static ProductDTO toDTO(ProductBO bo) {
        ProductDTO dto = new ProductDTO();
        dto.setId(bo.getId());
        dto.setDescription(bo.getDescription());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());

        return dto;
    }

}
