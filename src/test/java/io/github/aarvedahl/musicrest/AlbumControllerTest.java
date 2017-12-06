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
        Song song = new Song("I knew you were trouble", false, 4);
        album.addSong(song);
        song = new Song("I almost do", false, 5);
        album.addSong(song);
        song = new Song("We are never ever getting back together", true, 2);
        album.addSong(song);
        albumList.add(album);

    }

    @Test
    public void showFavorite() {
        for(Song song1: albumController.showFavorites(albumList)) {
            assertEquals(true, song1.isFavorite());
        }
    }

    @Test
    public void sortOnRating() {
        assertEquals("I almost do", albumController.sortOnRating(albumList).get(0).getSongTitle());
        assertEquals("I knew you were trouble", albumController.sortOnRating(albumList).get(1).getSongTitle());
    }

    @Test
    public void getAlbumList() {
        assertEquals(1, albumController.getAlbumList().size());
        assertEquals(3, albumController.getAlbumList().get(0).getSongs().size());
        assertEquals(1, albumController.getAlbumList().size());
        assertEquals(3, albumController.getAlbumList().get(0).getSongs().size());
    }
}
