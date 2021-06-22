package com.lana.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lana.lookify.models.Songs;
import com.lana.lookify.repositories.SongsRepo;



@Service
public class SongsService {
 private final SongsRepo songsRepo;
 public SongsService( SongsRepo songsRepo) {
	 this.songsRepo = songsRepo;
 }
 
 public List<Songs> allsongs(){
	 return songsRepo.findAll();
 }
 public List<Songs> getSongByArtist(String artist) {
	 return songsRepo.findByArtist(artist);
 }
 public void createSong(Songs song) {
	 songsRepo.save(song);
	 
 }
 public List<Songs> topTen(){
	 return songsRepo.findTop10ByOrderByRatingDesc();
 }
 public void delete(Long id) {
	 songsRepo.deleteById(id);
 }
 
 public Songs showById(Long id) {
	 return songsRepo.findById(id).orElse(null);
 }


}
