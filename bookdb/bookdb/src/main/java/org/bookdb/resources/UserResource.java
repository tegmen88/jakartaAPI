package org.bookdb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.bookdb.model.User;
import org.bookdb.service.UserService;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        List<User> users = userService.findAll();
        
        if(users.isEmpty()){
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }

   @GET
   @Path("/{id}")
   public Response getUser(@PathParam("id") @Min(1) Long id) {
       User user = userService.findById(id);

       return Response.ok(user).build();
   }

   @GET
   @Path("/count")
   public Response countBooks() {
      Long count = userService.countAll();
      return Response.ok(count).build();
   }

    @POST
   public Response createUser(User user) throws URISyntaxException {
        user = userService.createUser(user);
        URI createdUri = new URI(user.getId().toString());
       return Response.created(createdUri).entity(user).build();
   }

   @DELETE
   @Path("/{id}")
   public Response deleteUser(@PathParam("id") @Min(1) Long id) {
        userService.deleteById(id);
        return Response.noContent().build();
   }

   @PATCH
   @Path("/{id}")
   public Response updateBook(@PathParam("id") @Min(1) Long id, User user) {
       user = userService.updateUser(id, user);
       return Response.ok(user).build();
   }
    
}
