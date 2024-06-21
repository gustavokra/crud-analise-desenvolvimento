package com.kraemer.presentation.controllers;

import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.StockService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/v1/stock")
public class StockController {

    @Inject 
    private StockService stockService;
    
    @POST
    @Path("/create")
    public Response create(StockDTO dto, EnumDataBase dataBase) {
        var createdStock = stockService.create(dto, dataBase);
        return Response.ok(createdStock).build();
    }

    @GET
    @Path("/returnAll")
    public Response returnAll(StockDTO dto, EnumDataBase dataBase) {
        var allStocks = stockService.returnAll(dataBase);
        return Response.ok(allStocks).build();
    }

    @GET
    @Path("/findById")
    public Response findById(Long id, EnumDataBase dataBase) {
        var stockFound = stockService.findById(id, dataBase);
        return Response.ok(stockFound).build();
    }

    @PUT
    @Path("/update")
    public Response update(StockDTO dto, Long id, EnumDataBase dataBase) {
        var stockUpdated = stockService.update(dto, id, dataBase);
        return Response.ok(stockUpdated).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(Long id, EnumDataBase dataBase) {
        var disabledStock = stockService.disable(id, dataBase);
        return Response.ok(disabledStock).build();
    }

}
