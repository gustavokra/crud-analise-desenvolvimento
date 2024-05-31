package org.acme.presentation.controllers;

import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/api/v1/user")
public class UserController {

    @Inject UserService userService;
    
    @GET
    public Response findBy(@HeaderParam Long userId, @HeaderParam EnumDBImpl dbImpl) {
        var userFound = userService.findBy(userId, dbImpl);

        return Response.ok(userFound).build();
    }
}
