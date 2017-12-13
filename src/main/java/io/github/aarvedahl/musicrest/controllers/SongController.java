package io.github.aarvedahl.musicrest.controllers;


import io.github.aarvedahl.musicrest.jpa.Song;
import io.github.aarvedahl.musicrest.repository.AlbumRepository;
import io.github.aarvedahl.musicrest.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class SongController {


    @Autowired SongRepository songRepository;

    List<Song> songList;


}
