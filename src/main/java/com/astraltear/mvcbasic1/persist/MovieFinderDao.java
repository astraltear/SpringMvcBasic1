package com.astraltear.mvcbasic1.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.astraltear.mvcbasic1.service.SimpleMovieService;

@Repository
public class MovieFinderDao {
	private static final Logger logger = LoggerFactory.getLogger(SimpleMovieService.class);
	
	public MovieFinderDao() {
		logger.info("MovieFinderDao INIT CALL!!!");
	}
}
