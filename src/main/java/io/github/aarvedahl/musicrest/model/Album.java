package io.github.aarvedahl.musicrest.model;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String artist;
    private String albumTitle;
    private String genre;
    private String albumLogo;
    public List<Song> songs = new ArrayList<>();

    public Album() { }
    public Album(String artist, String albumTitle, String genre, String albumLogo) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.albumLogo = albumLogo;
    }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
    public void addSong(Song song) { songs.add(song); }
    public String getAlbumLogo() { return albumLogo; }
    public String getAlbumTitle() { return albumTitle;  }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public void setAlbumTitle(String albumTitle) { this.albumTitle = albumTitle; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbumLogo(String albumLogo) { this.albumLogo = albumLogo; }
    public void setGenre(String genre) { this.genre = genre; }
}
