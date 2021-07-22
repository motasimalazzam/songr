package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albums( Model model) {
//        ArrayList<Album> albums= new ArrayList<>();
//        Album helem = new Album("Helem", "Abdul Majeed Abdullah", 4, 960, "https://img.discogs.com/Q2mgE44tbkI3RM2kngPmiUvOj8M=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-11049906-1508919427-1766.jpeg.jpg");
//        Album fiOrbak = new Album("Fi Orbak", "Asalah", 9, 2160, "https://i.ytimg.com/vi/aSyIrej6hyU/hqdefault.jpg");
//        Album algharamAlmostaheel = new Album("Algharam Almostaheel", "Wael Kfoury", 8, 1920, "https://i.ytimg.com/vi/NuPfJDRkW-E/hqdefault.jpg");
//        albums.add(helem);
//        albums.add(fiOrbak);
//        albums.add(algharamAlmostaheel);
        model.addAttribute("album", albumRepository.findAll());
        return "album";
    }

    @GetMapping("/addAlbum")
    public String addAlbum() {
        return "addedAlbums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="imageUrl") String imageUrl,
                                 @RequestParam(value="length") long length) {
        Album album = new Album(title,artist,songCount,length,imageUrl);

        albumRepository.save(album);
        return  new RedirectView("/albums");
    }
}
