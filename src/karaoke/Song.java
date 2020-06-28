package karaoke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Song {
    private String title;
    private String artist;
    private List<String> lyrics;

    public Song(String newTitle, String newArtist, List<String> newLyrics){
        this.title = newTitle;
        this.artist = newArtist;
        this.lyrics = newLyrics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<String> lyrics) {
        this.lyrics = lyrics;
    }

    public static List<String> parseLyrics(String lyrics) {
        List<String> parsedLyrics;
            parsedLyrics = Arrays.asList(lyrics.split(" "));
        return parsedLyrics;
    }
}

