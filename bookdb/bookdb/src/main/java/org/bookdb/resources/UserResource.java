package org.bookdb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.bookdb.model.User;
import org.bookdb.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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
    @Operation(summary = "Visa alla användare", description = "Hämtar och visar alla användare i databasen.")
    @APIResponse(
        responseCode = "200",
        description = "Alla användare"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Inga användare hittades"  
    )
    public Response getAllUsers() {
        List<User> users = userService.findAll();
        
        if(users.isEmpty()){
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }

   @GET
   @Path("/{id}")
   @Operation(summary = "Visa en specifik användare", description = "Hämtar och visar en specifik användare med ID")
    @APIResponse(
        responseCode = "200",
        description = "Alla böcker"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Inga böcker hittades"  
    )
    @APIResponse(
        responseCode = "401",
        description = "Api-nyckel saknas eller är felaktig"  
    )
   public Response getUser(@PathParam("id") @Min(1) Long id) {
       User user = userService.findById(id);

       return Response.ok(user).build();
   }

   @GET
   @Path("/count")
    @Operation(summary = "Räkna användare", description = "Räknar antalet användare i databasen.")
     @APIResponse(
          responseCode = "200",
          description = "Antal användare"  
     )
     @APIResponse(
          responseCode = "204",
          description = "Inga användare hittades"  
     )
     @APIResponse(
          responseCode = "401",
          description = "Api-nyckel saknas eller är felaktig"  
     )
   public Response countBooks() {
      Long count = userService.countAll();
      return Response.ok(count).build();
   }

    @POST
    @Operation(summary = "Skapa användare", description = "Skapar en ny användare")
    @APIResponse(
        responseCode = "201",
        description = "Användare skapad"  
    )
    @APIResponse(
        responseCode = "400",
        description = "Felaktig data"  
    )
   public Response createUser(User user) throws URISyntaxException {
        user = userService.createUser(user);
        URI createdUri = new URI(user.getId().toString());
       return Response.created(createdUri).entity(user).build();
   }

   @DELETE
   @Path("/{id}")
   @Operation(summary = "Radera användare", description = "Raderar en användare med ID")
    @APIResponse(
          responseCode = "201",
          description = "Användare raderad"  
     )
     @APIResponse(
          responseCode = "401",
          description = "Api-nyckel saknas eller är felaktig"  
     )
   public Response deleteUser(@PathParam("id") @Min(1) Long id) {
        userService.deleteById(id);
        return Response.noContent().build();
   }

   @PATCH
   @Path("/{id}")
    @Operation(summary = "Uppdatera användare", description = "Uppdaterar en användare med ID")
     @APIResponse(
             responseCode = "201",
             description = "Användare uppdaterad"  
      )
      @APIResponse(
             responseCode = "401",
             description = "Api-nyckel saknas eller är felaktig"  
      )
   public Response updateBook(@PathParam("id") @Min(1) Long id, User user) {
       user = userService.updateUser(id, user);
       return Response.ok(user).build();
   }
    
}
