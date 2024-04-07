package dev.tgodahewa.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable("imdbId") String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
