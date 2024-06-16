package com.kraemer.presentation.controllers;

import java.util.List;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.AddressService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/address")
public class AddressController {

    @Inject
    AddressService addressService;

    @POST
    @Path("/create")
    public Response create(AddressDTO addressDTO, @HeaderParam EnumDataBase dataBase) {
        AddressDTO createdAddress = addressService.createAddress(addressDTO, dataBase);
        return Response.ok(createdAddress).build();
    }

    @GET
    @Path("/return-all")
    public Response returnAll(@HeaderParam EnumDataBase dataBase) {
        List<AddressDTO> allAdressReturned = addressService.returnAllAddress(dataBase);
        return Response.ok(allAdressReturned).build();
    }

    @GET
    @Path("/return-by-id")
    public Response returnAddressById(@HeaderParam Long id, @HeaderParam EnumDataBase database) {
        AddressDTO addressReturned = addressService.returnAddress(id, database);
        return Response.ok(addressReturned).build(); 
    }

    @PUT
    @Path("/update-info")
    public Response updateInfo(AddressDTO addressDTO, @HeaderParam Long idAddressToUpdate, @HeaderParam EnumDataBase database) {
        AddressDTO updatedAddress = addressService.updateAddressInfo(addressDTO, idAddressToUpdate, database);
        return Response.ok(updatedAddress).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(@HeaderParam Long idAddressToDisable, @HeaderParam EnumDataBase dataBase) {
        AddressDTO disabledAddres = addressService.disableAddress(idAddressToDisable, dataBase);
        return Response.ok(disabledAddres).build();
    }

}
