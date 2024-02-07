package org.bookdb;

import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response getAllBooks() {
        List<Book> books = bookService.findAll();
        
        if(books.isEmpty()){
            return Response.noContent().build();
        }

        return Response.ok(books).build();
    }

   @GET
   @Path("/{id}")
   public Response getBook(@PathParam("id") @Min(1) Long id) {
       Book book = bookService.findById(id);
       return Response.ok(book).build();
   }

   @GET
   @Path("/count")
   public Response countBooks() {
      Long count = bookService.countAll();
      return Response.ok(count).build();
   }

   @POST
   public Response createBook(Book book) throws URISyntaxException {
        book = bookService.createBook(book);
        URI createdUri = new URI(book.getId().toString());
       return Response.created(createdUri).entity(book).build();
   }

//    @DELETE
//    @Path("/{id}")
//    public Response deleteBook(@PathParam("id") Long id) {

    //        return Response.ok().build();
//    }

   @DELETE
   @Path("/{id}")
   public Response deleteBook(@PathParam("id") @Min(1) Long id) {
        bookService.deleteById(id);
        return Response.noContent().build();
   }
}
