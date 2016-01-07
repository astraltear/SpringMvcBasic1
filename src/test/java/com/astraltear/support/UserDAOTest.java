package com.astraltear.support;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.astraltear.mvcbasic1.domain.User;
import com.astraltear.mvcbasic1.persist.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class UserDAOTest {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOTest.class);


	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void crud() throws Exception{
		User user = new User("darap", "darapPW", "다레이프", "darap@naver.com");
		userDAO.create(user);
		User actual = userDAO.findById(user.getUserid());
		log.info("<<<<<<<<<< User >>>>>>>>>>>>>>>> : {}", actual);
		
		assertThat(actual, CoreMatchers.is(user));
	}
	
/*	@Test
	public void drop() throws Exception{
		userDAO.deleteAll();
	}*/

}
