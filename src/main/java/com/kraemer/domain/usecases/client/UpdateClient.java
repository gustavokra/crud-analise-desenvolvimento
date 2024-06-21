package com.kraemer.domain.usecases.client;

import java.util.List;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.ClientMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ClientRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateClient {
    
    private ClientRepository repository;

    public UpdateClient(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDTO execute(ClientDTO dto, Long id) {

        var queryFieldId = new QueryFieldVO("id", id);

        var clientToUpdate = repository.findFirstBy(List.of(queryFieldId));

        if(clientToUpdate == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        clientToUpdate.handleUpdate(ClientMapper.toBO(dto));

        repository.merge(clientToUpdate);

        return ClientMapper.toDTO(clientToUpdate);
        
    }

}
