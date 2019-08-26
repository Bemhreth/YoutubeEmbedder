package com.EmpowerYouth;

public class YoutubeConfig {
    static String id="AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0";

    YoutubeConfig() {  }

    public static String getId() {
        return id;
    }

    //private static final String id="AIzaSyBpLXOALntQ6FN3JbXRMLVyQTlcCsW4zbE";

    static String getLink() {
        return link;
    }

    static void setLink(String link){
        YoutubeConfig.link = link;
    }

    String chanelId="UCXgGY0wkgOzynnHvSEVmE3A";
    String videoId="SdH4QdyHn18";
    private static String link="SdH4QdyHn18";
    String API="https://www.googleapis.com/youtube/v3/videos?id="+link+"&key=AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0&part=snippet,contentDetails,statistics,status";
    String API1="https://www.googleapis.com/youtube/v3/search?key=AIzaSyBU4sPMEdeK0FMa16Y1dAok5uIhhnDMpx0&channelId="+chanelId+"&part=snippet,id&order=date&maxResults=20";

}

