package com.company.repository;

import com.company.model.one_to_many_b.User_B;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository_B {

    @PersistenceContext
    private EntityManager entityManager;


    public User_B save(User_B user) {
        entityManager.persist(user);
        return user;
    }


    public User_B update(User_B user) {
        entityManager.merge(user);
        return user;
    }

    public List<User_B> findAll() {
        return entityManager.createQuery("from User_B u").getResultList();
    }

    public List<User_B> findByEmail(String email) {
        return entityManager.createQuery("from User_B u where u.email =:email").setParameter("email", email).getResultList();
    }

    public void delete(Integer id) {
        User_B u = entityManager.find(User_B.class, id);
        if (u != null) {
            entityManager.remove(u);
        }
    }
}
