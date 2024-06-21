package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.usecases.seller.CreateSeller;
import com.kraemer.domain.usecases.seller.DisableSeller;
import com.kraemer.domain.usecases.seller.FindSellerBy;
import com.kraemer.domain.usecases.seller.ReturnAllSellers;
import com.kraemer.domain.usecases.seller.UpdateSeller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SellerService extends AbstractService {

    @Transactional
    public SellerDTO create(SellerDTO dto, EnumDataBase dataBase) {
        SellerRepository repository = sellerRepositoryFactory.getRepository(dataBase);
        var create = new CreateSeller(repository);
        return create.execute(dto);
    }

    public List<SellerDTO> returnAll(EnumDataBase dataBase) {
        SellerRepository repository = sellerRepositoryFactory.getRepository(dataBase);
        var returnAll = new ReturnAllSellers(repository);
        return returnAll.execute();
    }

    public SellerDTO findById(Long stockId, EnumDataBase dataBase) {
        SellerRepository repository = sellerRepositoryFactory.getRepository(null);
        var findBy = new FindSellerBy(repository);
        QueryFieldVO queryField = new QueryFieldVO("id", stockId);
        return findBy.execute(List.of(queryField), true);
    }

    @Transactional
    public SellerDTO update(SellerDTO dto, Long id, EnumDataBase dataBase) {
        SellerRepository repository = sellerRepositoryFactory.getRepository(dataBase);
        var update = new UpdateSeller(repository);
        return update.execute(dto, id);
    }

    @Transactional
    public SellerDTO disable(Long id, EnumDataBase dataBase) {
        SellerRepository repository = sellerRepositoryFactory.getRepository(dataBase);
        var disable = new DisableSeller(repository);
        return disable.execute(id);
    }

}
