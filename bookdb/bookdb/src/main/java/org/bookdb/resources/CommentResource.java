package org.bookdb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.bookdb.model.Book;
import org.bookdb.model.Comment;
import org.bookdb.model.User;
import org.bookdb.service.CommentService;
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

@Path("/api/comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentService commentService;

    // Get all comments
    @GET
    @Operation(summary = "Hämtar kommentarer", description = "Hämtar alla kommentarer i databasen.")
    @APIResponse(
        responseCode = "200",
        description = "Kommentarer hämtades"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Kommentarer hittades inte"  
    )
    @APIResponse(
        responseCode = "401",
        description = "Api-nyckel saknas eller är felaktig"  
    )
    public Response getCommments() {
        List<Comment> comments = commentService.findAll();

        if (comments.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(comments).build();
    }

    // Post
    @POST
    @Operation(summary = "Skapar kommentar", description = "Lägger till en kommentar i databasen.")
    @APIResponse(
        responseCode = "200",
        description = "Kommentar skapad"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Misslyckades att skapa kommentar"  
    )
    @APIResponse(
        responseCode = "401",
        description = "Api-nyckel saknas eller är felaktig"  
    )
    public Response addComment(Comment comment) throws URISyntaxException   {
        
        Book book = comment.getBook();
        User user = comment.getUser();
        if (book == null || book.getId() == null) {


            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Null: Lägga till comment fungerar inte!")
                           .build();
        }

        comment.setBook(book);
        comment.setUser(user);

        comment = commentService.addComment(comment);

        URI createdUri = new URI(comment.getId().toString());
        return Response.created(createdUri).entity(comment).build();
       
    }

    // Get one comment
    @GET
    @Path("/{id}")
    @Operation(summary = "Hämtar kommentar", description = "Hämtar en specifik kommentar med ID")
    @APIResponse(
        responseCode = "200",
        description = "Kommentar hämtad"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Kommentaren finns inte"  
    )
    @APIResponse(
        responseCode = "401",
        description = "Api-nyckel saknas eller är felaktig"  
    )
    @APIResponse(
        responseCode = "404",
        description = "Hittades inte"  
    )

    public Response getComment(@PathParam("id") @Min(1) Long id) {
        Comment comment = commentService.findById(id);
        
        if (comment == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("404: noto found Null: Kommentaren finns inte").build();
        }
        return Response.ok(comment).build();
    }

    // Delete
   @DELETE
    @Path("/{id}")
    @Operation(summary = "Tar bort kommentar", description = "Tar bort en specifik kommentar med ID")
    @APIResponse(
        responseCode = "200",
        description = "Kommentar borttagen"  
    )
    @APIResponse(
        responseCode = "204",
        description = "Kommentaren hittades inte"  
    )
    @APIResponse(
        responseCode = "401",
        description = "Api-nyckel saknas eller är felaktig"  
    )
    public Response deleteComment(@PathParam("id") Long id) {
        commentService.delete(id);

        return Response.noContent().build();
    }

    // Patch
    @PATCH
    @Path("/{id}")
    @Operation(summary = "Uppdaterar kommentar", description = "Uppdaterar en specifik kommentar med ID")
    public Response updateComment(@PathParam("id") Long id, Comment updatedComment) {
        Comment comment = commentService.update(id, updatedComment);

        if (comment == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Null: Går inte uppdatera innehållet av objektet").build();
        }
        return Response.ok(comment).build();
    }

    // hämtar ut en specifik kommentar för en bok
    @GET
    @Path("/book/{bookId}")
    public Response getCommentsForBook(@PathParam("bookId") Long bookId) {
        List<Comment> comments = commentService.getCommentsByBookId(bookId);
        if (comments != null && !comments.isEmpty()) {
            return Response.ok(comments).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Inga kommentarer hittades för den angivna boken.").build();
        }
    }

}
