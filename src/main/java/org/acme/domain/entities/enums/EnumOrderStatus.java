package org.acme.domain.entities.enums;

public enum EnumOrderStatus {
    
    OP("Open", "OP");

    private EnumOrderStatus(String description, String abreviacao) {
        this.description = description;
        this.abreviacao = abreviacao;
    }

    private String description;

    private String abreviacao;

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    

}
