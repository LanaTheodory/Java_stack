package com.lana.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.lana.lookify.models.Songs;
import com.lana.lookify.services.SongsService;

@Controller
public class SongsController {
	
	private final SongsService songService;
	public SongsController(SongsService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String welcome(){
		
		return "welcome.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("song") Songs songs) {
		List<Songs> song = songService.allsongs();
		model.addAttribute("songs", song);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/search" )
	public String search(@RequestParam("artist") String artist,  @ModelAttribute("song") Songs songs ) {
		if(artist == "") {
			return "redirect:/dashboard";
		} else
		
		return "redirect:/search/"+artist;
		
	}
	
	
	@RequestMapping(value="/search/{artist}" )
	public String searchTwo(@PathVariable("artist") String artist,@ModelAttribute("song")Songs song, Model model ) {
		List<Songs> atrists = songService.getSongByArtist(artist);
		
		if(atrists.isEmpty()) {
			return "redirect:/dashboard";
		
		
		}else
			model.addAttribute("artist", artist);
			model.addAttribute("ArtistSongs",atrists );
		return "search.jsp";
		
		
	}
	
	@RequestMapping("/song/new")
	public String addnew(@ModelAttribute("song")Songs song) {
		
		return "new.jsp";
	}
	@PostMapping("/song/newsong")
	public String addNewSong(@Valid @ModelAttribute("song")Songs song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		songService.createSong(song);
		
		return "redirect:/dashboard";
	}
	@RequestMapping("/topSongs")
	public String topSongs(Model model) {
		List<Songs> top = songService.topTen();
		model.addAttribute("top", top);
		
		return "top.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String deletes(@PathVariable("id")Long id ) {
		songService.delete(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Songs thisSong = songService.showById(id);
		model.addAttribute("song", thisSong);
		
		return "show.jsp";
		
	}
	}

		

	



