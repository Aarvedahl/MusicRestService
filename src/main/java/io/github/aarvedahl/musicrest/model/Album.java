package io.github.aarvedahl.musicrest.model;

public class Album {

    private String artist;
    private String albumTitle;
    private String genre;
    private String albumLogo;


    public String getAlbumLogo() { return albumLogo; }
    public String getAlbumTitle() { return albumTitle;  }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public void setAlbumTitle(String albumTitle) { this.albumTitle = albumTitle; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbumLogo(String albumLogo) { this.albumLogo = albumLogo; }
    public void setGenre(String genre) { this.genre = genre; }
}
