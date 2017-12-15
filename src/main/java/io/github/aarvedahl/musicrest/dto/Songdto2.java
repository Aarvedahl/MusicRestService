package io.github.aarvedahl.musicrest.dto;

public class Songdto2 {

    private String songtitle;
    private boolean isFavorite;
    private double rating;
    private int albumid;

    public Songdto2() { }
    public Songdto2(String title, boolean isFavorite, double rating, int albumid) {
        this.songtitle = title;
        this.isFavorite = isFavorite;
        this.rating = rating;
        this.albumid = albumid;
    }

    public void setAlbumid(int albumid) { this.albumid = albumid; }
    public int getAlbumid() { return albumid; }
    public String getSongtitle() { return songtitle; }
    public boolean isFavorite() {
        return isFavorite;
    }
    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle;
    }
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
