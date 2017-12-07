package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.jpa.Album;
import io.github.aarvedahl.musicrest.model.Albumdto;
import io.github.aarvedahl.musicrest.model.Songdto;
import io.github.aarvedahl.musicrest.repository.AlbumRepository;
import io.github.aarvedahl.musicrest.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired AlbumRepository albumRepository;

    @Autowired SongRepository songRepository;

    List<Albumdto> albumList;
    List<Album> enities;

    public List<Songdto> showFavorites(List<Albumdto> albums) {
        List<Songdto> songList = new LinkedList<>();
        for(Albumdto album: albums) {
            for(Songdto song: album.getSongs()) {
                if(song.isFavorite()) {
                    songList.add(song);
                }
            }
        }
        return songList;
    }

    public List<Songdto> sortOnRating(List<Albumdto> albumList) {
        // Visa max ev. 25 st
        List<Songdto> bestRatings = new LinkedList<>();
        for(Albumdto album: albumList) {
            for(Songdto song: album.getSongs()) {
                bestRatings.add(song);
            }
        }
        bestRatings.sort(new RatingComparator());
        return bestRatings;
    }

    // TODO Sedan koppla mot PG och JPA

    @RequestMapping(method = RequestMethod.GET)
    public List<Albumdto> getAlbumList() {
        if(albumList == null) {
            albumList = new ArrayList<>();
            Albumdto album = new Albumdto("Taylor Swift", "Red", "Pop", "https://upload.wikimedia.org/wikipedia/en/c/c0/Taylor_Swift_-_Red_%28Single%29.png");
            Songdto song = new Songdto("I knew you were trouble", false, 4);
            album.addSong(song);
            song = new Songdto("I almost do", false, 5);
            album.addSong(song);
            song = new Songdto("We are never ever getting back together", true, 2);
            album.addSong(song);
            albumList.add(album);
        }
        return albumList;
    }


    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public List<Album> albums() {
        if(enities == null) {
            enities = albumRepository.findAll();
        }
        return enities;
    }

    @RequestMapping(value = "/sortOnRating", method = RequestMethod.GET)
    public List<Songdto> topSongs() {
        return sortOnRating(getAlbumList());
    }

    @RequestMapping(value = "/showFavorites", method = RequestMethod.GET)
    public List<Songdto> favorites() {
        return showFavorites(getAlbumList());
    }

    class RatingComparator implements Comparator<Songdto> {
        @Override
        public int compare(Songdto a, Songdto b) {
            return a.getRating() > b.getRating() ? -1 : a.getRating() == b.getRating() ? 0 : 1;
        }
    }

}
