package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.jpa.Album;
import io.github.aarvedahl.musicrest.jpa.Song;
import io.github.aarvedahl.musicrest.model.Albumdto;
import io.github.aarvedahl.musicrest.model.Songdto;
import io.github.aarvedahl.musicrest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired AlbumRepository albumRepository;

    List<Albumdto> albumdtos;
    List<Albumdto> mockList;
    List<Album> albums;

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

    @RequestMapping(value = "/mocklist", method = RequestMethod.GET)
    public List<Albumdto> getMockList() {
        if(mockList == null) {
            mockList = new ArrayList<>();
            Albumdto album = new Albumdto("Taylor Swift", "Red", 1, "https://upload.wikimedia.org/wikipedia/en/c/c0/Taylor_Swift_-_Red_%28Single%29.png");
            Songdto song = new Songdto("I knew you were trouble", false, 4);
            album.addSong(song);
            song = new Songdto("I almost do", false, 5);
            album.addSong(song);
            song = new Songdto("We are never ever getting back together", true, 2);
            album.addSong(song);
            mockList.add(album);
        }
        return mockList;
    }


    @RequestMapping(value = "/getAlbum/{albumid}", method = RequestMethod.GET)
    public Albumdto getOneAlbum(@PathVariable("albumid") int albumid) {
        Album album = albumRepository.findByAlbumid(albumid);
        Albumdto albumdto = new Albumdto(album.getArtist(), album.getAlbumtitle(), album.getAlbumid(), album.getAlbumlogo());
        for(Song song: album.getSongs()) {
            Songdto songdto = new Songdto(song.getSongtitle(), song.isFavorite(), song.getRating());
            albumdto.addSong(songdto);
        }
        return albumdto;
    }

    @CrossOrigin
    @GetMapping(value = "/getOneAlbum")
    public Albumdto getAlbum() {
        return getMockList().get(0);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<Albumdto> albums() {
        return getAlbumdtos();
    }

    @CrossOrigin
    @RequestMapping(value = "/sortOnRating", method = RequestMethod.GET)
    public List<Songdto> topSongs() {
        return sortOnRating(getAlbumdtos());
    }

    @CrossOrigin
    @RequestMapping(value = "/showFavorites", method = RequestMethod.GET)
    public List<Songdto> favorites() {
        return showFavorites(getAlbumdtos());
    }

    @CrossOrigin
    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String addAlbum(@RequestBody Album album) {
        return album.getAlbumtitle();
    }


    public List<Album> getAlbums() {
        if(albums == null) {
            albums = albumRepository.findAll();
        }
        return albums;
    }


    // TODO Lägg till album logo till varje sång
    public List<Albumdto> getAlbumdtos() {
        if(albumdtos == null) {
            albumdtos = new LinkedList<>();
            for(Album album: getAlbums()) {
                Albumdto albumdto = new Albumdto(album.getArtist(), album.getAlbumtitle(), album.getAlbumid(), album.getAlbumlogo());
                for(Song song: album.getSongs()) {
                    Songdto songdto = new Songdto(song.getSongtitle(), song.isFavorite(), song.getRating());
                    albumdto.addSong(songdto);
                }
                albumdtos.add(albumdto);
            }
        }
        return albumdtos;
    }

    class RatingComparator implements Comparator<Songdto> {
        @Override
        public int compare(Songdto a, Songdto b) {
            return a.getRating() > b.getRating() ? -1 : a.getRating() == b.getRating() ? 0 : 1;
        }
    }

}
