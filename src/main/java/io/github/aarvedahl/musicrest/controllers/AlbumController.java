package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.jpa.Album;
import io.github.aarvedahl.musicrest.jpa.Song;
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
            Albumdto album = new Albumdto("Taylor Swift", "Red", "Pop", "https://upload.wikimedia.org/wikipedia/en/c/c0/Taylor_Swift_-_Red_%28Single%29.png");
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Albumdto> albums() {
        return getAlbumdtos();
    }

    @RequestMapping(value = "/sortOnRating", method = RequestMethod.GET)
    public List<Songdto> topSongs() {
        return sortOnRating(getAlbumdtos());
    }

    @RequestMapping(value = "/showFavorites", method = RequestMethod.GET)
    public List<Songdto> favorites() {
        return showFavorites(getAlbumdtos());
    }


    public List<Album> getAlbums() {
        if(albums == null) {
            albums = albumRepository.findAll();
        }
        return albums;
    }


    public List<Albumdto> getAlbumdtos() {
        if(albumdtos == null) {
            albumdtos = new LinkedList<>();
            for(Album album: getAlbums()) {
                Albumdto albumdto = new Albumdto(album.getArtist(), album.getAlbumlogo(), album.getGenre(), album.getAlbumtitle());
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
