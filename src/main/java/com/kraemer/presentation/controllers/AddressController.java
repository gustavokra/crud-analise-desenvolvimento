package com.kraemer.presentation.controllers;

import java.util.List;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.AddressService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/address")
public class AddressController {

    @Inject 
    AddressService addressService;
    
    @POST
    @Path("/create")
    public Response createAddress(AddressDTO addressDTO, @HeaderParam EnumDataBase dataBase) {
        AddressDTO createdAddress = addressService.createAddress(addressDTO, dataBase);

        return Response.ok(createdAddress).build();
    }

    @GET
    @Path("/returnAll")
    public Response returnAllAddress(@HeaderParam EnumDataBase dataBase) {
        List<AddressDTO> allAdressReturned = addressService.returnAllAddress(dataBase);
        return Response.ok(allAdressReturned).build();
    }

}
