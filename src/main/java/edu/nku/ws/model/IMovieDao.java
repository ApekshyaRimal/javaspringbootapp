package edu.nku.ws.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IMovieDao extends CrudRepository<Movie, Long> {

    public Iterable<Movie> findAll();
    public Movie findByMovieId(int movieId);
    public long count();
}
