package io.github.aarvedahl.musicrest.model;

public class Song {

    private String songTitle;
    private boolean isFavorite;


    public String getSongTitle() {
        return songTitle;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
