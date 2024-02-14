package org.bookdb.resources;

import java.util.List;

import org.bookdb.model.Book;
import org.bookdb.model.Comment;
import org.bookdb.service.BookService;
import org.bookdb.service.CommentService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.net.URI;
import java.net.URISyntaxException;

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

@Path("/api/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

   

    @GET
    @Operation(summary = "Visa alla böcker", description = "Hämtar och visar alla böcker i databasen.")
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
    public Response getAllBooks() {
        List<Book> books = bookService.findAll();
        
        if(books.isEmpty()){
            return Response.noContent().build();
        }

        return Response.ok(books).build();
    }

   @GET
   @Path("/{id}")
   @Operation(summary = "Hämtar bok", description = "Hämtar en specifik bok med ID")
   @APIResponse(
       responseCode = "200",
       description = "Bok hämtad"  
   )
   @APIResponse(
       responseCode = "204",
       description = "Boken finns inte"  
   )
   @APIResponse(
       responseCode = "401",
       description = "Api-nyckel saknas eller är felaktig"  
   )
   public Response getBook(@PathParam("id") @Min(1) Long id) {
       Book book = bookService.findById(id);
       
       return Response.ok(book).build();
   }

   @GET
   @Path("/count")
    @Operation(summary = "Räknar böcker", description = "Räknar antalet böcker i databasen.")
   public Response countBooks() {
      Long count = bookService.countAll();
      return Response.ok(count).build();
   }

   
   
   @POST
   @Operation(summary = "Skapar ny bok", description = "Lägger till bok i databasen.")
   @APIResponse(
       responseCode = "200",
       description = "Bok skapad"  
   )
   @APIResponse(
       responseCode = "204",
       description = "Bok kunde inte skapas"  
   )
   @APIResponse(
       responseCode = "401",
       description = "Api-nyckel saknas eller är felaktig"  
   )
   public Response createBook(Book book) throws URISyntaxException {
        book = bookService.createBook(book);
        URI createdUri = new URI(book.getId().toString());
       return Response.created(createdUri).entity(book).build();
   }

   @DELETE
   @Path("/{id}")
   @Operation(summary = "Tar bort bok", description = "Tar bort en specifik bok med ID")
   @APIResponse(
       responseCode = "204",
       description = "Boken borttagen"  
   )
   @APIResponse(
       responseCode = "401",
       description = "Api-nyckel saknas eller är felaktig"  
   )
   public Response deleteBook(@PathParam("id") @Min(1) Long id) {
        bookService.deleteById(id);
        return Response.noContent().build();
   }

   @PATCH
   @Path("/{id}")
   @Operation(summary = "Uppdaterar bok", description = "Uppdaterar en specifik bok med ID")   
   public Response updateBook(@PathParam("id") @Min(1) Long id, Book book) {
       book = bookService.updateBook(id, book);
       return Response.ok(book).build();
   }

}
