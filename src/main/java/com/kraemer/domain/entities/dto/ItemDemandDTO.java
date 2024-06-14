package com.kraemer.domain.entities.dto;

import java.time.LocalDateTime;

public class ItemDemandDTO extends CrudDTO {



    private DemandDTO demandDTO;

    private ProductDTO productDTO;

    private UnitMeasureDTO unitMeasureDTO;

    private Integer amount;

    

   

   

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







    

    






}
