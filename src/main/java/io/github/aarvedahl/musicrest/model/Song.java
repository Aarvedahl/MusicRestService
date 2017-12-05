package io.github.aarvedahl.musicrest.model;

public class Song {

    private String songTitle;
    private boolean isFavorite;
    private double rating;

    public Song() { }
    public Song(String title, boolean isFavorite, double rating) {
        this.songTitle = title;
        this.isFavorite = isFavorite;
        this.rating = rating;
    }

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
