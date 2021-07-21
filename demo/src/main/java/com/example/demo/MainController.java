package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Locale;


@org.springframework.stereotype.Controller
public class MainController {

//    http://localhost:8080/hello
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


}
