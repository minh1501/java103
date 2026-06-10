package entity;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

    private Serializable group;
    private Long likes;
    private Date newest;
    private Date oldest;

    public Report() {
    }

    public Report(
            Serializable group,
            Long likes,
            Date newest,
            Date oldest) {

        this.group = group;
        this.likes = likes;
        this.newest = newest;
        this.oldest = oldest;
    }

    public Serializable getGroup() {
        return group;
    }

    public void setGroup(Serializable group) {
        this.group = group;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Date getNewest() {
        return newest;
    }

    public void setNewest(Date newest) {
        this.newest = newest;
    }

    public Date getOldest() {
        return oldest;
    }

    public void setOldest(Date oldest) {
        this.oldest = oldest;
    }
}