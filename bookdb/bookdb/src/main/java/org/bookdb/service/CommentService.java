package org.bookdb.service;


import java.util.List;

import org.bookdb.model.Book;
import org.bookdb.model.Comment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate.BooleanOperator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class CommentService{

    BookService bookService;

    @Inject
    EntityManager entityManager;

    // find all comments
     public List<Comment> findAll(){
        List<Comment> comments = entityManager.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
        return comments;
    }

    // find one comment


    // create
    @Transactional(Transactional.TxType.REQUIRED) 
    public Comment addComment(Comment comment){
       
        
        
        entityManager.persist(comment);
        return comment;
    }


    // delete


    // patch
}