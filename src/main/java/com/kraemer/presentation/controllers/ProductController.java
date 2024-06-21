package com.kraemer.presentation.controllers;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/v1/product")
public class ProductController {
    
    @Inject 
    private ProductService productService;
    
    @POST
    @Path("/create")
    public Response create(ProductDTO dto, EnumDataBase dataBase) {
        var createdStock = productService.create(dto, dataBase);
        return Response.ok(createdStock).build();
    }

    @GET
    @Path("/returnAll")
    public Response returnAll(ProductDTO dto, EnumDataBase dataBase) {
        var allStocks = productService.returnAll(dataBase);
        return Response.ok(allStocks).build();
    }

    @GET
    @Path("/findById")
    public Response findById(Long id, EnumDataBase dataBase) {
        var stockFound = productService.findById(id, dataBase);
        return Response.ok(stockFound).build();
    }

    @PUT
    @Path("/update")
    public Response update(ProductDTO dto, Long id, EnumDataBase dataBase) {
        var stockUpdated = productService.update(dto, id, dataBase);
        return Response.ok(stockUpdated).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(Long id, EnumDataBase dataBase) {
        var disabledStock = productService.disable(id, dataBase);
        return Response.ok(disabledStock).build();
    }

}
