package com.kraemer.domain.entities.enums;

import com.kraemer.domain.utils.EnumUtil;

public enum EnumCrudError implements IEnum {
    // Internal errors
    CAMPO_OBRIGATORIO("001", "O campo {0} é obrigatório!", 400),
    JA_CADASTRADO("002", "Já existe cadastro ativo!", 400),
    ITEM_NAO_ENCONTRADO_FILTROS("003", "Nenhum cadastro encontrado para ({0}) informado!", 404),
    CAMPO_INVALIDO("004", "{0} informado inválido!", 404),
    ITEM_CADASTRADO("005", "Usuário já cadastrado!", 400),
    ERRO_LISTAR("006", "Erro ao listar!", 400),
    ITEM_NAO_EXISTE("007", "Usuário não existe!", 400),
    USERNAME_JA_CADASTRADO("008", "Já existe um usuário com esse username!", 400),
    ITEM_ESTA_DESABILITADO("008", "Esse item está desabilitado", 400),
    // External errors
    ERRO_COMUNICACAO("050", "A requisição enviada ao parceiro retornou com erro!", 502);
    
    private final String key;

    private final String erro;

    private final int httpStatus;

    private EnumCrudError(String key, String error, int httpStatus) {
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

    public static EnumCrudError parseByKey(String key) {
        return (EnumCrudError) EnumUtil.parseByKey(EnumCrudError.class, key);
    }
}
