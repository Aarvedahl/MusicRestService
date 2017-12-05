package io.github.aarvedahl.musicrest;

import io.github.aarvedahl.musicrest.controllers.AlbumController;
import io.github.aarvedahl.musicrest.model.Album;
import io.github.aarvedahl.musicrest.model.Song;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AlbumControllerTest {
    AlbumController albumController;
    List<Album> albumList;
    @Before
    public void init() {
        albumController = new AlbumController();
        albumList = new ArrayList<>();
        Album album = new Album("Taylor Swift", "Red", "Pop", "url");
        Song song = new Song("I almost do", false, 3);
        album.addSong(song);
        song = new Song("We are never ever getting back together", true, 5);
        album.addSong(song);
        albumList.add(album);

    }


    @Test
    public void showFavorite() {
        Album album = new Album("Taylor Swift", "Red", "Pop", "url");
        Song song = new Song("We are never ever getting back together", true, 2);
        album.addSong(song);
        assertEquals(album.getSongs().get(0).getSongTitle(), albumController.showFavorites(albumList).get(0).getSongTitle());
        for(Song song1: albumController.showFavorites(albumList)) {
            assertEquals(true, song1.isFavorite());
        }
    }


    @Test
    public void sortOnRating() {
        Album album = new Album("Taylor Swift", "Red", "Pop", "url");
        Song song = new Song("I almost do", false, 3);
        album.addSong(song);
        song = new Song("We are never ever getting back together", true, 5);
        album.addSong(song);
        assertEquals(album.getSongs().get(0).getSongTitle(), albumController.sortOnRating(albumList).get(0).getSongTitle());
    }
}
