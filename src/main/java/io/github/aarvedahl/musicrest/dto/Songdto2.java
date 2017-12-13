package io.github.aarvedahl.musicrest.dto;

public class Songdto2 {

    private String songTitle;
    private boolean isFavorite;
    private double rating;
    private int albumid;

    public Songdto2() { }
    public Songdto2(String title, boolean isFavorite, double rating, int albumid) {
        this.songTitle = title;
        this.isFavorite = isFavorite;
        this.rating = rating;
        this.albumid = albumid;
    }

    public void setAlbumid(int albumid) { this.albumid = albumid; }
    public int getAlbumid() { return albumid; }
    public String getSongTitle() { return songTitle; }
    public boolean isFavorite() {
        return isFavorite;
    }
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
