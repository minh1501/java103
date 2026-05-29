package entity;

import java.util.Date;

public class Favorite {
    private long id;
    private String userId;
    private String videoId;
    private Date likeDate;

    public Favorite() {
    }

    public Favorite(long id, String userId,
            String videoId, Date likeDate) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.likeDate = likeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}