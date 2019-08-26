package com.EmpowerYouth;

public class Model {
    // VIDEO ID WAS THE CRUCIAL PART

    private String videoID;
    private String viewed;
    private String title;
    private String description;
    private String likes;
    private String dislikes;
    private String Image_link;
    private String Video_title;
    private String Video_link;

    public String getVideo_link() {
        return Video_link;
    }

    public void setVideo_link(String video_link) {
        Video_link = video_link;
    }


    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getViewed() {
        return viewed;
    }

    public void setViewed(String viewed) {
        this.viewed = viewed;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }



    public String getImage_link() {
        return Image_link;
    }

    public void setImage_link(String image_link) {
        Image_link = image_link;
    }

    public String getVideo_title() {
        return Video_title;
    }

    public void setVideo_title(String video_title) {
        Video_title = video_title;
    }
}

