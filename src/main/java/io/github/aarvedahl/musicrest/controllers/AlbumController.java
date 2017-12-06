package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.model.Album;
import io.github.aarvedahl.musicrest.model.Song;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    List<Album> albumList;

    public List<Song> showFavorites(List<Album> albums) {
        List<Song> songList = new LinkedList<>();
        for(Album album: albums) {
            for(Song song: album.getSongs()) {
                if(song.isFavorite()) {
                    songList.add(song);
                }
            }
        }
        return songList;
    }

    public List<Song> sortOnRating(List<Album> albumList) {
        // Visa max ev. 25 st
        List<Song> bestRatings = new LinkedList<>();
        for(Album album: albumList) {
            for(Song song: album.getSongs()) {
                bestRatings.add(song);
            }
        }
        bestRatings.sort(new RatingComparator());
        return bestRatings;
    }

    // TODO Få igång en webservice, efter det koppla med docker och vagrant
    // TODO Sedan koppla mot PG och JPA

    @RequestMapping(method = RequestMethod.GET)
    public List<Album> getAlbumList() {
        if(albumList == null) {
            albumList = new ArrayList<>();
            Album album = new Album("Taylor Swift", "Red", "Pop", "url");
            Song song = new Song("I knew you were trouble", false, 4);
            album.addSong(song);
            song = new Song("I almost do", false, 5);
            album.addSong(song);
            song = new Song("We are never ever getting back together", true, 2);
            album.addSong(song);
            albumList.add(album);
        }
        return albumList;
    }



    @RequestMapping(value = "/sortOnRating", method = RequestMethod.GET)
    public List<Song> topSongs() {
        return sortOnRating(getAlbumList());
    }

    @RequestMapping(value = "/showFavorites", method = RequestMethod.GET)
    public List<Song> favorites() {
        return showFavorites(getAlbumList());
    }

    @RequestMapping(value = "/song")
    public String song() {
        return "This is a song";
    }

    class RatingComparator implements Comparator<Song> {
        @Override
        public int compare(Song a, Song b) {
            return a.getRating() > b.getRating() ? -1 : a.getRating() == b.getRating() ? 0 : 1;
        }
    }


}
