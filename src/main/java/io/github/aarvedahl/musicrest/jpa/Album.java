package io.github.aarvedahl.musicrest.jpa;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int albumid;
    @Column
    private String artist;
    @Column
    private String albumtitle;

    @Column
    private String genre;

    @Column
    private String albumlogo;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album() { }
    public Album(int albumid) {
        this.albumid = albumid;
    }

    public int getAlbumid() { return albumid; }
    public void setAlbumid(int albumid) { this.albumid = albumid; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getAlbumtitle() { return albumtitle; }
    public void setAlbumtitle(String albumtitle) { this.albumtitle = albumtitle; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getAlbumlogo() { return albumlogo; }
    public void setAlbumlogo(String albumLogo) { this.albumlogo = albumLogo; }

    @JsonManagedReference
    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}
