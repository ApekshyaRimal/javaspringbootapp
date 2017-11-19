package edu.nku.ws.controller;

import edu.nku.ws.model.IMovieDao;
import edu.nku.ws.model.Movie;
//import edu.nku.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

    private IMovieDao iMovieDao;

    @Autowired
    public MovieController(IMovieDao iMovieDao) {
        this.iMovieDao = iMovieDao;
    }

    @RequestMapping("/getAllMovies")
    @ResponseBody
    public ModelAndView getAllMovies(){
        Iterable<Movie> allMovies = this.iMovieDao.findAll();
        ModelAndView modelAndView = new ModelAndView("allMovies");
        modelAndView.addObject("movies", allMovies);
        return modelAndView;
    }

    @RequestMapping("/getByMovieId")
    @ResponseBody
    public ModelAndView getByMovieId(@RequestParam int movieId){
        Movie byMovieId = this.iMovieDao.findByMovieId(movieId);
        ModelAndView modelAndView = new ModelAndView("movie");
        modelAndView.addObject("myMovie", byMovieId);
        return modelAndView;
    }

    @RequestMapping("/countMovies")
    @ResponseBody
    public String countMovies(){
        return "Total movies releasing : " + this.iMovieDao.count();
    }
}
