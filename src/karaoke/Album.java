package karaoke;

import java.util.List;

public class Album {
    private String albumName;
    private List<Song> songs;

    public Album(String albumName, List<Song> songs) {
        this.albumName = albumName;
        this.songs = songs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void printTrackListings(){
        System.out.println(getAlbumName() + " listing...\n" + songs);
    }
}
