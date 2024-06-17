package com.kraemer.presentation.controllers;

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
        var createdAddress = addressService.create(addressDTO, dataBase);
        return Response.ok(createdAddress).build();
    }

    @GET
    @Path("/return-all")
    public Response returnAll(@HeaderParam EnumDataBase dataBase) {
        var allAddressReturned = addressService.returnAll(dataBase);
        return Response.ok(allAddressReturned).build();
    }

    @GET
    @Path("/find-by-id")
    public Response findById(@HeaderParam Long id, @HeaderParam EnumDataBase database) {
        var addressFound = addressService.findById(id, database);
        return Response.ok(addressFound).build();
    }

    @PUT
    @Path("/update")
    public Response update(AddressDTO addressDTO, @HeaderParam Long idAddressToUpdate, @HeaderParam EnumDataBase database) {
        var updatedAddress = addressService.update(addressDTO, idAddressToUpdate, database);
        return Response.ok(updatedAddress).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(@HeaderParam Long idAddressToDisable, @HeaderParam EnumDataBase dataBase) {
        var disabledAddres = addressService.disable(idAddressToDisable, dataBase);
        return Response.ok(disabledAddres).build();
    }

}
