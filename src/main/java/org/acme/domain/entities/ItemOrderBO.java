package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;

public class ItemOrderBO {

    private OrderBO orderBO;

    private ProductBO productBO;

    private UnitMeasureBO unitMeasureBO;

    private Integer amount;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public ItemOrderBO(OrderBO orderBO, ProductBO productBO, UnitMeasureBO unitMeasureBO, Integer amount,
            CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.orderBO = orderBO;
        this.productBO = productBO;
        this.unitMeasureBO = unitMeasureBO;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAtVO createdAt) {
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

    public OrderBO getorderBO() {
        return orderBO;
    }

    public void setorderBO(OrderBO orderBO) {
        this.orderBO = orderBO;
    }

    public ProductBO getproductBO() {
        return productBO;
    }

    public void setproductBO(ProductBO productBO) {
        this.productBO = productBO;
    }

    public UnitMeasureBO getunitMeasureBO() {
        return unitMeasureBO;
    }

    public void setunitMeasureBO(UnitMeasureBO unitMeasureBO) {
        this.unitMeasureBO = unitMeasureBO;
    }

    public Integer getamount() {
        return amount;
    }

    public void setamount(Integer amount) {
        this.amount = amount;
    }

}
