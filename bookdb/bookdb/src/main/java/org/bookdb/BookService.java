package org.bookdb;

import java.util.List;
import java.util.UUID;

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

}
