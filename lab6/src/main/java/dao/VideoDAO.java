package dao;

import java.util.List;

import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtils;

public class VideoDAO {

    public List<Video> findAll() {

        EntityManager em = JpaUtils.getEntityManager();

        String jpql = "SELECT v FROM Video v";

        TypedQuery<Video> query =
                em.createQuery(jpql, Video.class);

        return query.getResultList();
    }

    public Video findById(String id) {

        EntityManager em = JpaUtils.getEntityManager();

        return em.find(Video.class, id);
    }
}