package io.github.aarvedahl.musicrest.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int songid;

    @Column
    private String songtitle;
    @Column
    private boolean favorite;

    @Column
    private double rating;

    @ManyToOne
    @JoinColumn(name="albumid", referencedColumnName="albumid", nullable=false)
    private Album album;


    public Song() { }
    public int getSongid() { return songid; }
    public void setSongid(int songid) { this.songid = songid;    }
    public String getSongtitle() { return songtitle;    }
    public void setSongtitle(String songtitle) { this.songtitle = songtitle; }
    public boolean isFavorite() { return favorite;    }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }
    public double getRating() { return rating;    }
    public void setRating(double rating) { this.rating = rating; }
    public void setAlbum(Album album) { this.album = album; }

    @JsonBackReference
    public Album getAlbum() { return album; }
}
