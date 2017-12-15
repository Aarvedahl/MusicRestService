package io.github.aarvedahl.musicrest.controllers;

import io.github.aarvedahl.musicrest.dto.Songdto2;
import io.github.aarvedahl.musicrest.jpa.Album;
import io.github.aarvedahl.musicrest.jpa.Song;
import io.github.aarvedahl.musicrest.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {


    @Autowired SongRepository songRepository;

    List<Song> songList;

    @CrossOrigin
    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    public void addSong(@RequestBody Songdto2 song) {
        Song songjpa = new Song(song.getSongtitle(), song.isFavorite(), song.getRating(), new Album(song.getAlbumid()));
        songRepository.save(songjpa);
    }

}
