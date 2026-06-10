package dao;

import java.util.List;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtils;

public class UserDAO {

    public List<User> findAll() {

        EntityManager em = JpaUtils.getEntityManager();

        String jpql = "SELECT u FROM User u";

        TypedQuery<User> query =
                em.createQuery(jpql, User.class);

        return query.getResultList();
    }

    public User findById(String id) {

        EntityManager em = JpaUtils.getEntityManager();

        return em.find(User.class, id);
    }
}