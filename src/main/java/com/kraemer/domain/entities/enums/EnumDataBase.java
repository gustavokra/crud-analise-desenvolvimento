package com.kraemer.domain.entities.enums;

import com.kraemer.domain.utils.EnumUtil;

public enum EnumDataBase implements IEnum {

    POSTGRES("POSTGRES"),
    MONGO("MONGO"),
    MYSQL("MYSQL");

    private final String key;

    private EnumDataBase(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseToEnumByKey(key) != null;
    }

    public static EnumDataBase parseToEnumByKey(String key) {
        return (EnumDataBase) EnumUtil.parseByKey(EnumDataBase.class, key);
    }
}