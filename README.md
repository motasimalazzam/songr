# songr

## Architecture

The programing language used to build this project is Java and using the Spring MVC Data and Thymeleaf.

**Author**: Motasim Al-Azzam 

## Lab-11: Building Full-Stack Web Apps

### Overview

This lab about how to set up a basic webapp that bult with the Spring MVC Data and Thymeleaf.

### Routers: 

#### MainController Class

* `@GetMapping("/hello") String helloWorld()`: Go to the hello.html that contain **Hello world**.

* `@GetMapping("/capitalize/hello") String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)` : This router go to the HelloWorld.html page and this router contain `name` parameter, so in the html page it will render Hello and the name that sort in the `name` parameter in upper case.

* `@GetMapping("/albums") public String albums( Model model)` : This router go to the album.html page and this page contains the albums.

#### Album Class

The Album class contains 5 variables:

1. `String title`: To stor the album title.

2. `String artist`: To store the artist name.

3. `int songCount`: To stor the number of song in the album.

4. `long length` : To store the total lenght of song in seconds.

5. `String imageUrl` : To store the album image URL.

* Create a constructor and its parameters are all variables above. And also create a getter and setter methods for all variables.