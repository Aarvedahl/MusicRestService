package io.github.aarvedahl.musicrest.model;

import java.util.ArrayList;
import java.util.List;

public class Albumdto {

    private String artist;
    private String albumTitle;
    private String genre;
    private String albumLogo;
    public List<Songdto> songs = new ArrayList<>();

    public Albumdto() { }
    public Albumdto(String artist, String albumTitle, String genre, String albumLogo) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.albumLogo = albumLogo;
    }

    public List<Songdto> getSongs() { return songs; }
    public void setSongs(List<Songdto> songs) { this.songs = songs; }
    public void addSong(Songdto song) { songs.add(song); }
    public String getAlbumLogo() { return albumLogo; }
    public String getAlbumTitle() { return albumTitle;  }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public void setAlbumTitle(String albumTitle) { this.albumTitle = albumTitle; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbumLogo(String albumLogo) { this.albumLogo = albumLogo; }
    public void setGenre(String genre) { this.genre = genre; }
}
