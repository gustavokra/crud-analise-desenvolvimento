package com.kraemer.domain.entities.enums;

import com.kraemer.domain.utils.EnumUtil;

public enum EnumOrderStatus implements IEnum {
    
    OP("OPEN");

    private EnumOrderStatus(String key) {
        this.key = key;
    }

    private String key;

    public String getkey() {
        return key;
    }

    public void setkey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }
    
    public static EnumOrderStatus parseByKey(String key) {
        return (EnumOrderStatus) EnumUtil.parseByKey(EnumOrderStatus.class, key);
    }

}
