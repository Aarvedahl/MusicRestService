package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.model.Album;
import io.github.aarvedahl.musicrest.model.Song;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AlbumController {
// primitiva datatyper som är static hamnar på native minnet
    // En lista är en collection men collection är inte en lista
    // Collection är superklass till set, map, list etc
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

    class RatingComparator implements Comparator<Song> {
        @Override
        public int compare(Song a, Song b) {
            return a.getRating() > b.getRating() ? -1 : a.getRating() == b.getRating() ? 0 : 1;
        }
    }


}
