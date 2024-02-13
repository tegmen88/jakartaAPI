package org.bookdb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.bookdb.model.Book;
import org.bookdb.model.Comment;
import org.bookdb.model.User;
import org.bookdb.service.CommentService;

import jakarta.inject.Inject;
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
    public Response getCommments() {
        List<Comment> comments = commentService.findAll();

        if (comments.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(comments).build();
    }

    // Post
    @POST
    public Response addComment(Comment comment) throws URISyntaxException   {
        
        Book book = comment.getBook();
        User user = comment.getUser();
        if (book == null || book.getId() == null) {


            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Comment fungerar inte!")
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
    public Response getComment(@PathParam("id") Long id) {
        Comment comment = commentService.findById(id);
        
        if (comment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(comment).build();
    }

    // Delete
   @DELETE
    @Path("/{id}")
    public Response deleteComment(@PathParam("id") Long id) {
        commentService.delete(id);

        return Response.noContent().build();
    }

    // Patch
    @PATCH
    @Path("/{id}")
    public Response updateComment(@PathParam("id") Long id, Comment updatedComment) {
        Comment comment = commentService.update(id, updatedComment);

        if (comment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(comment).build();
    }

}
