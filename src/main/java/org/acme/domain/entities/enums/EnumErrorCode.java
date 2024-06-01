package org.acme.domain.entities.enums;

import org.acme.domain.utils.EnumUtil;

public enum EnumErrorCode implements IEnum {
    // Internal errors
    CAMPO_OBRIGATORIO("001", "O campo {0} é obrigatório!", 400),
    JA_CADASTRADO("002", "Já existe cadastro ativo!", 400),
    NAO_ENCONTRADO_FILTROS("003", "Nenhum cadastro encontrado para ({0}) informado!", 404),
    CAMPO_INVALIDO("004", "{0} informado inválido!", 404),
    USUARIO_NAO_EXISTE("005", "Usuário não existe!", 400),
    USUARIO_CADASTRADO("006", "Usuário já cadastrado!", 400),
    USERNAME_CADASTRADO("006", "Já existe um usuário com esse username!", 400),
    USUARIO_NAO_ENCONTRADO_FILTROS("007", "Nenhum usuário encontrado para ({0}) informado!", 404),
    // External errors
    ERRO_COMUNICACAO("050", "A requisição enviada ao parceiro retornou com erro!", 502);
    
    private final String key;

    private final String erro;

    private final int httpStatus;

    private EnumErrorCode(String key, String error, int httpStatus) {
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
