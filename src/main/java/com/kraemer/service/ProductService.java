package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.usecases.product.CreateProduct;
import com.kraemer.domain.usecases.product.DisableProduct;
import com.kraemer.domain.usecases.product.FindProductBy;
import com.kraemer.domain.usecases.product.ReturnAllProducts;
import com.kraemer.domain.usecases.product.UpdateProduct;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductService extends AbstractService {
    
    @Transactional
    public ProductDTO create(ProductDTO dto, EnumDataBase dataBase) {
        ProductRepository repository = productRepositoryFactory.getRepository(dataBase);
        var createProduct = new CreateProduct(repository);
        return createProduct.execute(dto);
    }

    public List<ProductDTO> returnAll(EnumDataBase dataBase) {
        ProductRepository repository = productRepositoryFactory.getRepository(dataBase);
        var returnAll = new ReturnAllProducts(repository);
        return returnAll.execute();
    }

    public ProductDTO findById(Long stockId, EnumDataBase dataBase) {
        ProductRepository repository = productRepositoryFactory.getRepository(null);
        var findStockBy = new FindProductBy(repository);
        QueryFieldVO queryField = new QueryFieldVO("id", stockId);
        return findStockBy.execute(List.of(queryField), true);
    }

    @Transactional
    public ProductDTO update(ProductDTO dto, Long id, EnumDataBase dataBase) {
        ProductRepository repository = productRepositoryFactory.getRepository(dataBase);
        var updateStock = new UpdateProduct(repository);
        return updateStock.execute(dto, id);
    }

    @Transactional
    public ProductDTO disable(Long id, EnumDataBase dataBase) {
        ProductRepository repository = productRepositoryFactory.getRepository(dataBase);
        var disableStock = new DisableProduct(repository);
        return disableStock.execute(id);
    }

}
