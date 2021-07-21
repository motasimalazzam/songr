package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Locale;


@Controller
public class MainController {
    @Autowired
 private AlbumRepo albumRepo;

//    http://localhost:8080/hell/o
    @GetMapping("/hello")
    String helloWorld(){
        return "hello";
    }


//    http://localhost:8080/capitalize/hello?name=motasim
    @GetMapping("/capitalize/{id}")
    String hello(Model model, @PathVariable("id") String id) {
        id.toUpperCase();
        model.addAttribute("name",id.toUpperCase());
        return "HelloWorld";
    }



    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") long length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepo.save(album);
        return  new RedirectView("/albums");
    }
}
