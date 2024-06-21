package com.kraemer.domain.usecases.client;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.mappers.ClientMapper;
import com.kraemer.domain.repositories.ClientRepository;
import com.kraemer.domain.utils.ListUtil;

public class ReturnAllClients {
    
    private ClientRepository repository;

    public ReturnAllClients(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDTO> execute() {
        return ListUtil.stream(repository.returnAll())
            .map(ClientMapper::toDTO)
            .collect(Collectors.toList());
    }

}
