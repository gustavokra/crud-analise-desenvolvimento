package com.kraemer.presentation.controllers;

import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.SellerService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/v1/seller")
public class SellerController {
    @Inject
    private SellerService sellerService;

    @POST
    @Path("/create")
    public Response create(SellerDTO dto, EnumDataBase dataBase) {

        var createdSeller = sellerService.create(dto, dataBase);

        return Response.ok(createdSeller).build();

    }

    @GET
    @Path("/returnAll")
    public Response returnAll(SellerDTO dto, EnumDataBase dataBase) {

        var allSellers = sellerService.returnAll(dataBase);

        return Response.ok(allSellers).build();

    }

    @GET
    @Path("/findById")
    public Response findById(Long id, EnumDataBase dataBase) {

        var sellerFound = sellerService.findById(id, dataBase);

        return Response.ok(sellerFound).build();

    }

    @PUT
    @Path("/update")
    public Response update(SellerDTO dto, Long id, EnumDataBase dataBase) {

        var sellerUpdated = sellerService.update(dto, id, dataBase);

        return Response.ok(sellerUpdated).build();

    }

    @DELETE
    @Path("/disable")
    public Response disable(Long id, EnumDataBase dataBase) {

        var disabledSeller = sellerService.disable(id, dataBase);

        return Response.ok(disabledSeller).build();

    }
}
