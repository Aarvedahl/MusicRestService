package io.github.aarvedahl.musicrest.repository;

import io.github.aarvedahl.musicrest.jpa.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
