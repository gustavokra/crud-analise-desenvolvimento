package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;

public class ItemDemandBO extends CrudBO {

    private DemandBO demandBO;

    private ProductBO productBO;

    private UnitMeasureBO unitMeasureBO;

    private Integer amount;

    public ItemDemandBO(Long id, DemandBO demandBO, ProductBO productBO, UnitMeasureBO unitMeasureBO, Integer amount,
            CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.demandBO = demandBO;
        this.productBO = productBO;
        this.unitMeasureBO = unitMeasureBO;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public DemandBO getDemandBO() {
        return demandBO;
    }

    public ProductBO getProductBO() {
        return productBO;
    }

    public UnitMeasureBO getUnitMeasureBO() {
        return unitMeasureBO;
    }

    public Integer getAmount() {
        return amount;
    }

}
