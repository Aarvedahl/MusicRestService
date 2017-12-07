package io.github.aarvedahl.musicrest;

import io.github.aarvedahl.musicrest.controllers.AlbumController;
import io.github.aarvedahl.musicrest.model.Albumdto;
import io.github.aarvedahl.musicrest.model.Songdto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AlbumControllerTest {
    AlbumController albumController;
    List<Albumdto> albumList;

    @Before
    public void init() {
        albumController = new AlbumController();
        albumList = new ArrayList<>();
        Albumdto album = new Albumdto("Taylor Swift", "Red", "Pop", "url");
        Songdto song = new Songdto("I knew you were trouble", false, 4);
        album.addSong(song);
        song = new Songdto("I almost do", false, 5);
        album.addSong(song);
        song = new Songdto("We are never ever getting back together", true, 2);
        album.addSong(song);
        albumList.add(album);

    }

    @Test
    public void showFavorite() {
        for(Songdto song1: albumController.showFavorites(albumList)) {
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
        assertEquals(1, albumController.getMockList().size());
        assertEquals(3, albumController.getMockList().get(0).getSongs().size());
        assertEquals(1, albumController.getMockList().size());
        assertEquals(3, albumController.getMockList().get(0).getSongs().size());
    }
}
