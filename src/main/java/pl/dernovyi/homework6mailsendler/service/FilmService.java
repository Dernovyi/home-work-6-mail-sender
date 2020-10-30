package pl.dernovyi.homework6mailsendler.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.dernovyi.homework6mailsendler.model.Film;

import java.util.ArrayList;
import java.util.List;
@Service
@Component
public class FilmService {
    List<Film> films;

    public FilmService() {
        this.films = new ArrayList<>();
        films.add(new Film("Mroczny Rycerz", 2008, "Christopher Nolan"));
        films.add(new Film("Historia małżeńska", 2019, "Noah Baumbach"));
        films.add(new Film("Joker", 2019, "Todd Phillips"));
        films.add(new Film("Zielona+mila", 1999, "Frank Darabont"));

    }

    public List<Film> getAllFilms(){
        return films;
    }

    public void addFilm(Film film ){
        films.add(film);
    }

    public Film getLastAdded(){
        int lastFilm = films.size()-1;
        return films.get(lastFilm);
    }
}
