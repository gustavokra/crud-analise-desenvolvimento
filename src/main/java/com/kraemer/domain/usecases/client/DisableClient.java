package com.kraemer.domain.usecases.client;

import java.util.List;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.mappers.ClientMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ClientRepository;

public class DisableClient {

    private ClientRepository repository;

    public DisableClient(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDTO execute(Long id) {
        var queryField = new QueryFieldVO("id", id);
        var clientToDisable = repository.findFirstBy(List.of(queryField));

        clientToDisable.handleDisable();

        return ClientMapper.toDTO(repository.merge(clientToDisable));
    }

}
