package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.services.SongService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/songs")
public class SongApiV1Controller {
  private SongService songService;

  @Autowired
  public SongApiV1Controller(SongService songService) {
    this.songService = songService;
  }

  @GetMapping
  public Page<Song> getSongsApi(Pageable pageable) {
    return songService.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Song getSingleSong(@PathVariable Integer id){
    return songService.findById(id).orElseThrow(()->new SongNotFoundException());
  }

  @NoArgsConstructor
  private class SongNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class SongNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SongNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String songNotFoundHandler(SongNotFoundException ex) {
      return ex.getMessage();
    }
  }
}
