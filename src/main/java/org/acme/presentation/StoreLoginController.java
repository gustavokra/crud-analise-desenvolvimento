package org.acme.presentation;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;
import jakarta.ws.rs.Path;

@Path("/api/v1/store-login")
public class StoreLoginController {
    
    public void login(@HeaderParam String username, @HeaderParam String password) {

        

    }

}
