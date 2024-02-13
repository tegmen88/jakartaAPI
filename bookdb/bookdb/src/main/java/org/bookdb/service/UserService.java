package org.bookdb.service;

import java.util.List;
import java.util.UUID;

import org.bookdb.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class UserService {
    
    @Inject
    EntityManager entityManager;

    UUID uuid;

    public User findByApiKey(UUID apiKey) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.apiKey = :apiKey", User.class)
                    .setParameter("apiKey", apiKey)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> findAll(){
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    public User findById(Long id){
        return entityManager.find(User.class, id);
    }

    public Long countAll(){
        return entityManager.createQuery("SELECT COUNT(u) FROM Book u", Long.class).getSingleResult();
    }

    @Transactional(Transactional.TxType.REQUIRED) 
        public User createUser(@Valid User user){
        user.setApiKey(UUID.randomUUID());
        entityManager.persist(user);
        return user;
    }

    @Transactional(Transactional.TxType.REQUIRED) 
    public void deleteById(Long id){
        entityManager.remove(entityManager.getReference(User.class, id));

    }

    @Transactional(Transactional.TxType.REQUIRED) 
    public User updateUser(Long id, User updatedUser) {
        User existingUser = entityManager.find(User.class, id);
        existingUser.setUserName(existingUser.getUserName());
        existingUser.setPassword(existingUser.getPassword());

        return entityManager.merge(existingUser);
    }

}
