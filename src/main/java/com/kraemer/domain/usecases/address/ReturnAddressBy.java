package com.kraemer.domain.usecases.address;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class ReturnAddressBy {

    private AddressRepository addressRepository;

    public ReturnAddressBy(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(List<QueryFieldInfoVO> queryFields, boolean throwsException) {
        var addressBO = addressRepository.returnFirstBy(queryFields);

        if (addressBO == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldInfoVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return addressBO != null ? AddressMapper.mapAddressBOToDTO(addressBO) : null;
    }

}
