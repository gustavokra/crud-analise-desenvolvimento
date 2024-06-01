package org.acme.presentation.controllers;

import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.OPTIONS;
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
    public Response create(UserDTO dto, @HeaderParam EnumDBImpl dbImpl) {
        var createdUser = userService.create(dto, dbImpl);

        return Response.ok(createdUser).build();
    }

    @GET
    public Response findBy(@HeaderParam Long userId, @HeaderParam EnumDBImpl dbImpl) {
        var userFound = userService.findBy(userId, dbImpl);

        return Response.ok(userFound).build();
    }

    @POST
    @Path("/login")
    public Response findByLogin(@HeaderParam String username,
            @HeaderParam String password,
            @HeaderParam EnumDBImpl dbImpl) {
        var userFound = userService.findByLogin(username, password, dbImpl);

        return Response.ok(userFound).build();
    }

    @GET
    @Path("/all")
    public Response findAllBy(@HeaderParam String document, @HeaderParam EnumDBImpl dbImpl) {
        var usersFound = userService.listBy(document, dbImpl);

        return Response.ok(usersFound).build();
    }

    @PUT
    public Response find(UserDTO dto, @HeaderParam Long userId, @HeaderParam EnumDBImpl dbImpl) {
        var updatedUser = userService.updateInfo(dto, userId, dbImpl);

        return Response.ok(updatedUser).build();
    }

    @DELETE
    public Response disable(@HeaderParam Long userId, @HeaderParam EnumDBImpl dbImpl) {
        var desibledUser = userService.disable(userId, dbImpl);

        return Response.ok(desibledUser).build();
    }

}
