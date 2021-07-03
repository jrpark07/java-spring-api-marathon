package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {
  private SongService songService;

  @Autowired
  public SongController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping
  public String getSongsIndex(Model model, Pageable pageable) {
    model.addAttribute("songs", songService.findAll(pageable));
    return "songs/index";
  }

  @GetMapping("/new")
  public String getNewSong(@ModelAttribute Song song) {
    return "songs/new";
  }

  @PostMapping
  public String createSong(@ModelAttribute Song song) {
    if(songService.save(song))
      return "redirect:/songs";
    else
      return "/songs/new";
  }
}
