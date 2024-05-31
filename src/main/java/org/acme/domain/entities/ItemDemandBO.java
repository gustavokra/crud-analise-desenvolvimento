package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class ItemDemandBO implements ICrudBO {

    private Long id;

    private DemandBO demandBO;

    private ProductBO productBO;

    private UnitMeasureBO unitMeasureBO;

    private Integer amount;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

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

    public Long getId() {
        return id;
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

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

}
