package org.bookdb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.bookdb.model.Book;
import org.bookdb.model.Comment;
import org.bookdb.service.CommentService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
        if (book == null || book.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Comment fungerar inte!")
                           .build();
        }

        comment.setBook(book);

        comment = commentService.addComment(comment);

        URI createdUri = new URI(comment.getId().toString());
        return Response.created(createdUri).entity(comment).build();
       
    }


    // Get one comment


    // Delete



    // Patch
    
}
