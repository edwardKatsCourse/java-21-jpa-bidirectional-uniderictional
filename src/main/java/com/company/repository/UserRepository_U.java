package com.company.repository;

import com.company.model.one_to_many_u.User_U;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository_U {

    @PersistenceContext
    private EntityManager entityManager;

    public User_U save(User_U user) {
        entityManager.persist(user);
        return user;
    }


    public User_U update(User_U user) {
        entityManager.merge(user);
        return user;
    }

    public List<User_U> findAll() {
        return entityManager.createQuery("from User_U u").getResultList();
    }

    public List<User_U> findByEmail(String email) {
        return entityManager.createQuery("from User_U u where u.email =:email").setParameter("email", email).getResultList();
    }

    public void delete(Integer id) {
        User_U u = entityManager.find(User_U.class, id);
        if (u != null) {

            entityManager.remove(u);
        }
    }
}
