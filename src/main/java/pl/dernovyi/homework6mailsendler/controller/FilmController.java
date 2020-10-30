package pl.dernovyi.homework6mailsendler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dernovyi.homework6mailsendler.annotation.MyAspect;
import pl.dernovyi.homework6mailsendler.model.Film;
import pl.dernovyi.homework6mailsendler.service.FilmService;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    FilmService filmService;
    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){
        List<Film> films = filmService.getAllFilms();
        if(films.size()>0){
            return new ResponseEntity<>(films, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    @MyAspect
    public void addFilm(@RequestBody Film film, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new ValidationException("Film is not valid");
        }
        filmService.addFilm(film);
    }
}
