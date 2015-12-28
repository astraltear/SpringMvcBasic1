package com.astraltear.mvcbasic1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astraltear.mvcbasic1.persist.MovieFinderDao;

@Service
public class SimpleMovieService {
	private static final Logger logger = LoggerFactory.getLogger(SimpleMovieService.class);
	
	private MovieFinderDao dao;
	
	public SimpleMovieService() {
		logger.info("SimpleMovieService INIT CALL!!!");
	}
	
	@Autowired
	public SimpleMovieService(MovieFinderDao movieDao) {
		this.dao = movieDao;
		logger.info("SimpleMovieService PARAM CONSTRUCTOR CALL!!!");
	}
	
	
}
