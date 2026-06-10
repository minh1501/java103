package dao;

import java.util.List;

import entity.Favorite;
import entity.Report;
import entity.User;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtils;

public class FavoriteDAO {

    // Tìm Favorite theo User
    public List<Favorite> findByUser(String userId) {

        EntityManager em = JpaUtils.getEntityManager();

        try {
            User user = em.find(User.class, userId);

            if (user == null) {
                return List.of();
            }

            return user.getFavorites();

        } finally {
            em.close();
        }
    }

    // Tìm Video theo từ khóa
    public List<Video> findVideoByKeyword(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT DISTINCT o.video " +
                    "FROM Favorite o " +
                    "WHERE o.video.title LIKE :keyword";

            TypedQuery<Video> query =
                    em.createQuery(jpql, Video.class);

            query.setParameter(
                    "keyword",
                    "%" + keyword + "%");

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Tìm User đã thích Video
    public List<User> findUserByVideo(String videoId) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT o.user " +
                    "FROM Favorite o " +
                    "WHERE o.video.id = :id";

            TypedQuery<User> query =
                    em.createQuery(jpql, User.class);

            query.setParameter("id", videoId);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Video đã có người thích
    public List<Video> findFavoriteVideos() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT DISTINCT f.video " +
                    "FROM Favorite f";

            TypedQuery<Video> query =
                    em.createQuery(jpql, Video.class);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Video chưa có người thích
    public List<Video> findNotFavoriteVideos() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT v " +
                    "FROM Video v " +
                    "WHERE v.favorites IS EMPTY";

            TypedQuery<Video> query =
                    em.createQuery(jpql, Video.class);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Thống kê lượt thích
    public List<Report> getReport() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT new entity.Report(" +
                    "o.video.title," +
                    "COUNT(o)," +
                    "MAX(o.likeDate)," +
                    "MIN(o.likeDate)) " +
                    "FROM Favorite o " +
                    "GROUP BY o.video.title";

            TypedQuery<Report> query =
                    em.createQuery(jpql, Report.class);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Thêm Favorite
    public void create(Favorite favorite) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(favorite);

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
        }
    }

    // Xóa Favorite
    public void delete(Long id) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            Favorite favorite =
                    em.find(Favorite.class, id);

            if (favorite != null) {

                em.getTransaction().begin();

                em.remove(favorite);

                em.getTransaction().commit();
            }

        } catch (Exception e) {

            em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
        }
    }

    // Tìm tất cả Favorite
    public List<Favorite> findAll() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT f FROM Favorite f";

            TypedQuery<Favorite> query =
                    em.createQuery(jpql, Favorite.class);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    // Tìm theo ID
    public Favorite findById(Long id) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            return em.find(Favorite.class, id);

        } finally {
            em.close();
        }
    }
}