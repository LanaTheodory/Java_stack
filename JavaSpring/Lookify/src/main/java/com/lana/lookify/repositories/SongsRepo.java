package com.lana.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.lookify.models.Songs;

@Repository
public interface SongsRepo extends CrudRepository<Songs, Long> {
	
	List<Songs> findAll();
	List<Songs> findByArtist(String str);
	List<Songs> findTop10ByOrderByRatingDesc();
	

}
