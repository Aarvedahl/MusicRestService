package io.github.aarvedahl.musicrest.repository;

import io.github.aarvedahl.musicrest.jpa.Album;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findByAlbumid(int albumid);
}
