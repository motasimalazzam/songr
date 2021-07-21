package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String albums( Model model) {
        ArrayList<Album> albums= new ArrayList<>();
        Album helem = new Album("Helem", "Abdul Majeed Abdullah", 4, 960, "https://img.discogs.com/Q2mgE44tbkI3RM2kngPmiUvOj8M=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-11049906-1508919427-1766.jpeg.jpg");
        Album fiOrbak = new Album("Fi Orbak", "Asalah", 9, 2160, "https://i.ytimg.com/vi/aSyIrej6hyU/hqdefault.jpg");
        Album algharamAlmostaheel = new Album("Algharam Almostaheel", "Wael Kfoury", 8, 1920, "https://i.ytimg.com/vi/NuPfJDRkW-E/hqdefault.jpg");
        albums.add(helem);
        albums.add(fiOrbak);
        albums.add(algharamAlmostaheel);
        model.addAttribute("album", albums);
        return "album";
    }
}
