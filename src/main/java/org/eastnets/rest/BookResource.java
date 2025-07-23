package org.eastnets.rest;

import org.eastnets.model.Book;
import org.eastnets.service.BookService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookService bookService = new BookService();

    @GET
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @POST
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") int id) {
        bookService.deleteBook(id);
    }
}
