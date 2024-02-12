package org.bookdb.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class CommentService{

    @Inject
    EntityManager entityManager;

    // find all comments


    // find one comment


    // create


    // delete


    // patch
}