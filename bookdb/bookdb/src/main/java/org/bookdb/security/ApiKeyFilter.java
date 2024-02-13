package org.bookdb.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.inject.Inject;
import org.bookdb.service.UserService;
import org.bookdb.model.User;

import java.util.UUID;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class ApiKeyFilter implements ContainerRequestFilter {

    @Inject
    UserService userService;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String path = requestContext.getUriInfo().getPath();
        String apiKey = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Tillåt att skapa och se användare utan API-nyckel
        if (path.equals("/api/user") && (requestContext.getMethod().equalsIgnoreCase("POST") || requestContext.getMethod().equalsIgnoreCase("GET"))) {
            return;
        }

        if (apiKey == null || apiKey.isEmpty()) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }

        User user = userService.findByApiKey(UUID.fromString(apiKey));
        if (user == null) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}