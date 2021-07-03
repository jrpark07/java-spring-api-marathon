package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
//  List<Song> findByName(String name);
}
