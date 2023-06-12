package com.exa.MovieBookingApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	
	
@Query(value="SELECT * FROM Movie")	
public List<Movie> viewMovieList();
 
}
