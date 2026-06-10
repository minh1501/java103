package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Videos")

@NamedQuery(
    name = "Video.findByKeyword",
    query = "SELECT v FROM Video v WHERE v.title LIKE :keyword"
)

@NamedStoredProcedureQuery(
    name = "Video.favoriteReport",
    procedureName = "spFavoriteReport"
)

public class Video {

    @Id
    private String id;

    private String title;

    private String poster;

    private String description;

    private Integer views;

    private Boolean active;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;

    public Video() {
    }

    public Video(String id, String title, String poster,
                 String description, Integer views,
                 Boolean active) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.views = views;
        this.active = active;
    }

    // Getter & Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Video [id=" + id
                + ", title=" + title
                + ", poster=" + poster
                + ", description=" + description
                + ", views=" + views
                + ", active=" + active + "]";
    }
}