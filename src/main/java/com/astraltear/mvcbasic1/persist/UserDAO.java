package com.astraltear.mvcbasic1.persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.astraltear.mvcbasic1.domain.User; 

public class UserDAO extends JdbcDaoSupport {
	
	@PostConstruct
	public void initialize() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("user.sql"));
		DatabasePopulatorUtils.execute(populator, getDataSource());
	}

	public User findById(String userId) {
		
		String sql = "select * from users where userid=?";
		
		RowMapper<User> rowMapper = new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("userid"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
			}
		};
		
		return getJdbcTemplate().queryForObject(sql, rowMapper,userId);
	}

	public void create(User user) {
		String sql ="insert into users values(?,?,?,?)";
		getJdbcTemplate().update(sql, user.getUserid(),user.getPassword(),user.getName(),user.getEmail());
	}

	public void deleteAll() {
		String sql="delete from users";
		getJdbcTemplate().update(sql);
		
	}
 
}
