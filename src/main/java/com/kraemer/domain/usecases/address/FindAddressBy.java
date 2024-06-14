package com.kraemer.domain.usecases.address;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindAddressBy {

    private IAddressRepository addressRepository;

    public FindAddressBy(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(List<QueryFieldInfoVO> queryFields, boolean throwsException) {
        var addressBO = addressRepository.findFirstBy(queryFields);

        if (addressBO == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldInfoVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return addressBO != null ? AddressMapper.toDTO(addressBO) : null;
    }

}
