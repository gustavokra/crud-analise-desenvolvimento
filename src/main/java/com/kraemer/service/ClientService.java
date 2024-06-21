package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ClientRepository;
import com.kraemer.domain.usecases.client.CreateClient;
import com.kraemer.domain.usecases.client.DisableClient;
import com.kraemer.domain.usecases.client.FindClientBy;
import com.kraemer.domain.usecases.client.ReturnAllClients;
import com.kraemer.domain.usecases.client.UpdateClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClientService extends AbstractService {
    
    @Transactional
    public ClientDTO create(ClientDTO dto, EnumDataBase dataBase) {
        ClientRepository repository = clientRepositoryFactory.getRepository(dataBase);
        var create = new CreateClient(repository);
        return create.execute(dto);
    }

    public List<ClientDTO> returnAll(EnumDataBase dataBase) {
        ClientRepository repository = clientRepositoryFactory.getRepository(dataBase);
        var returnAll = new ReturnAllClients(repository);
        return returnAll.execute();
    }

    public ClientDTO findById(Long stockId, EnumDataBase dataBase) {
        ClientRepository repository = clientRepositoryFactory.getRepository(null);
        var findBy = new FindClientBy(repository);
        QueryFieldVO queryField = new QueryFieldVO("id", stockId);
        return findBy.execute(List.of(queryField), true);
    }

    public ClientDTO update(ClientDTO dto, Long id, EnumDataBase dataBase) {
        ClientRepository repository = clientRepositoryFactory.getRepository(dataBase);
        var update = new UpdateClient(repository);
        return update.execute(dto, id);
    }

    public ClientDTO disable(Long id, EnumDataBase dataBase) {
        ClientRepository repository = clientRepositoryFactory.getRepository(dataBase);
        var disable = new DisableClient(repository);
        return disable.execute(id);
    }
}
