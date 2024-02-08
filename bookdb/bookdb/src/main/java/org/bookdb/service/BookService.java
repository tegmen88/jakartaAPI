package org.bookdb.service;

import java.util.List;
import java.util.UUID;

import org.bookdb.model.Book;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class BookService {

    @Inject
    EntityManager entityManager;

    UUID uuid;

    public List<Book> findAll(){
        List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        return books;
    }

    public Book findById(Long id){
        return entityManager.find(Book.class, id);
    }

    public Long countAll(){
        return entityManager.createQuery("SELECT COUNT(b) FROM Book b", Long.class).getSingleResult();
    }
    
    @Transactional(Transactional.TxType.REQUIRED) 
    public Book createBook(@Valid Book book){
        book.setIsbn(uuid.randomUUID());
        entityManager.persist(book);
        return book;
    }

    @Transactional(Transactional.TxType.REQUIRED) 
    public void deleteById(Long id){
        entityManager.remove(entityManager.getReference(Book.class, id));

    }

    @Transactional(Transactional.TxType.REQUIRED) 
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = entityManager.find(Book.class, id);
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setYear(updatedBook.getYear());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setComment(updatedBook.getComment());
            existingBook.setGenre(updatedBook.getGenre());
        return entityManager.merge(existingBook);
    }

}
