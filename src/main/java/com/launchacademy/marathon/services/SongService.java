package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {
  private SongRepository songRepository;

  @Autowired
  private SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  public Page<Song> findAll(Pageable pageable) {
    return songRepository.findAll(pageable);
  }

  public boolean save(Song song) {
    try {
      songRepository.save(song);
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("\n\n*********** Exception in save **********\n\n");
      return false;
    }
    return true;
  }

  public Optional<Song> findById(Integer id) {
    return songRepository.findById(id);
  }
}
