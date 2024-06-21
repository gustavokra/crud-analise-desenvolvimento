package com.kraemer.domain.usecases.client;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.mappers.ClientMapper;
import com.kraemer.domain.repositories.ClientRepository;

public class CreateClient {
    
    private ClientRepository repository;

    public CreateClient(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDTO execute(ClientDTO dto) {
        var createdClient = repository.create(ClientMapper.toBO(dto));
        return ClientMapper.toDTO(createdClient);
    }
    

}
