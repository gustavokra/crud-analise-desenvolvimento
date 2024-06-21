package com.kraemer.domain.usecases.client;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.ClientBO;
import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.ClientMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ClientRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindClientBy {

    private ClientRepository repository;

    public FindClientBy(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDTO execute(List<QueryFieldVO> queryFields, boolean throwsException) {
        ClientBO clientFound = repository.findFirstBy(queryFields);
        
        if(clientFound == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
            .map(QueryFieldVO::getFieldName)
            .collect(Collectors.joining());

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return clientFound == null ?  ClientMapper.toDTO(clientFound) : null;
    }

}
