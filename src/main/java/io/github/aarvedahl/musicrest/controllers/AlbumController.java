package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.model.Album;
import io.github.aarvedahl.musicrest.model.Song;

import java.util.LinkedList;
import java.util.List;

public class AlbumController {

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

        return albumList.get(0).getSongs();
    }

}
