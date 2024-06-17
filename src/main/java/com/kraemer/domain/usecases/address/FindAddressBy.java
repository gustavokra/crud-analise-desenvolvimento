package com.kraemer.domain.usecases.address;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindAddressBy {

    private AddressRepository addressRepository;

    public FindAddressBy(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(List<QueryFieldVO> queryFields, boolean throwsException) {
        var addressBO = addressRepository.findFirstBy(queryFields);

        if (addressBO == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return addressBO != null ? AddressMapper.toDTO(addressBO) : null;
    }

}
