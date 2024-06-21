package com.kraemer.presentation.controllers;

import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.ClientService;
import com.kraemer.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/v1/client")
public class ClientController {
    @Inject
    private ClientService clientService;

    @POST
    @Path("/create")
    public Response create(ClientDTO dto, EnumDataBase dataBase) {
        var createdClient = clientService.create(dto, dataBase);
        return Response.ok(createdClient).build();
    }

    @GET
    @Path("/returnAll")
    public Response returnAll(ClientDTO dto, EnumDataBase dataBase) {
        var allClients = clientService.returnAll(dataBase);
        return Response.ok(allClients).build();
    }

    @GET
    @Path("/findById")
    public Response findById(Long id, EnumDataBase dataBase) {
        var clientFound = clientService.findById(id, dataBase);
        return Response.ok(clientFound).build();
    }

    @PUT
    @Path("/update")
    public Response update(ClientDTO dto, Long id, EnumDataBase dataBase) {
        var clientUpdated = clientService.update(dto, id, dataBase);
        return Response.ok(clientUpdated).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(Long id, EnumDataBase dataBase) {
        var disabledClient = clientService.disable(id, dataBase);
        return Response.ok(disabledClient).build();
    }
}
