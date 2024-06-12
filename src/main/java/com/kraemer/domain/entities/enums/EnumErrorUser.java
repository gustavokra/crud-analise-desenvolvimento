package com.kraemer.domain.entities.enums;

import com.kraemer.domain.utils.EnumUtil;

public enum EnumErrorUser implements IEnum {
    // Internal errors
    USUARIO_NAO_EXISTE("001", "Usuário não existe!", 400);

    private final String key;

    private final String erro;

    private final int httpStatus;

    private EnumErrorUser(String key, String error, int httpStatus) {
        this.key = key;
        this.erro = error;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getErro() {
        return erro;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumErrorCode parseByKey(String key) {
        return (EnumErrorCode) EnumUtil.parseByKey(EnumErrorCode.class, key);
    }
}
