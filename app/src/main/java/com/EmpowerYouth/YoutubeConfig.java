package com.EmpowerYouth;

public class YoutubeConfig {
    static String id="AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0";

    public YoutubeConfig() {  }

    public static String getId() {
        return id;
    }

    //private static final String id="AIzaSyBpLXOALntQ6FN3JbXRMLVyQTlcCsW4zbE";

    public static String getLink() {
        return link;
    }
    String videoId="qkSBmRAVXNc";
    static final String link="qkSBmRAVXNc";
    String API="https://www.googleapis.com/youtube/v3/videos?id="+videoId+"&key=AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0&part=snippet,contentDetails,statistics,status";
    String API1="https://www.googleapis.com/youtube/v3/search?key=AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0&channelId=UCXgGY0wkgOzynnHvSEVmE3A&part=snippet,id&order=date&maxResults=20";

}

