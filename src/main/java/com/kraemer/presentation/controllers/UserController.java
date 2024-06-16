package com.kraemer.presentation.controllers;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/user")
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Path("/create")
    public Response create(UserDTO dto, @HeaderParam EnumDataBase dbImpl) {
        var createdUser = userService.create(dto, dbImpl);

        return Response.ok(createdUser).build();
    }

    @GET
    @Path("list-all")
    public Response listAll(@HeaderParam EnumDataBase dbImpl) {
        var allUsers = userService.listAll(dbImpl);

        return Response.ok(allUsers).build();
    }

    @GET
    @Path("/browse-by-document")
    public Response listAllBy(@HeaderParam String document, @HeaderParam EnumDataBase dbImpl) {
        var usersFound = userService.listBy(document, dbImpl);

        return Response.ok(usersFound).build();
    }

    @GET()
    @Path("/browse-by-id")
    public Response browseById(@HeaderParam Long userId, @HeaderParam EnumDataBase dbImpl) {
        var userFound = userService.findBy(userId, dbImpl);

        return Response.ok(userFound).build();
    }

    @PUT
    @Path("/update")
    public Response edit(UserDTO dto, @HeaderParam Long userId, @HeaderParam EnumDataBase dbImpl) {
        var userUpdated = userService.updateInfo(dto, userId, dbImpl);

        return Response.ok(userUpdated).build();
    }

    @DELETE
    @Path("/disable")
    public Response disable(@HeaderParam Long userId, @HeaderParam EnumDataBase dbImpl) {
        var userDisabled = userService.disable(userId, dbImpl);

        return Response.ok(userDisabled).build();
    }

    @POST
    @Path("/login")
    public Response findByLogin(@HeaderParam String username,
            @HeaderParam String password,
            @HeaderParam EnumDataBase dbImpl) {
        var userFound = userService.findByLogin(username, password, dbImpl);

        return Response.ok(userFound).build();
    }
}
