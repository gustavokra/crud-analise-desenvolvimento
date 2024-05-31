package org.acme.domain.entities.dto;

import java.time.LocalDateTime;

public class ItemDemandDTO {

    private Long id;

    private DemandDTO demandDTO;

    private ProductDTO productDTO;

    private UnitMeasureDTO unitMeasureDTO;

    private Integer amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public DemandDTO getDemandDTO() {
        return demandDTO;
    }

    public void setOrderDTO(DemandDTO demandDTO) {
        this.demandDTO = demandDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public UnitMeasureDTO getUnitMeasureDTO() {
        return unitMeasureDTO;
    }

    public void setUnitMeasureDTO(UnitMeasureDTO unitMeasureDTO) {
        this.unitMeasureDTO = unitMeasureDTO;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
