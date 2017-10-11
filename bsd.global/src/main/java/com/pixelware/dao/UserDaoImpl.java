package com.pixelware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pixelware.model.User;


/**
 * COmponente  NO web que trbaja en la capa de BBDD
 * @author HP_USer
 *
 */

@Repository
public class UserDaoImpl implements UserDao{
	private NamedParameterJdbcTemplate template;
	@Autowired
	public void setTemplate(NamedParameterJdbcTemplate template){
		this.template = template;
	}
	
	private static final class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setCode(rs.getInt("code"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			
			return user;
		}
		
	}
	public List<User> getAll() {
		Map<String,Object>params = new HashMap<>();
		String SQL = "SELECT code,name,email FROM users";
		List<User> users = template.query(SQL,params, new UserMapper());
		return users;
	}

	public User getByName(String name) {
		Map<String,Object>params = new HashMap<>();
		String SQL = "SELECT code,name,email FROM users WHERE name=:name";
		params.put("name",name);
		User user = template.queryForObject(SQL, params,new UserMapper());
		return user;
	}

	public User getByCode(int code) {
		Map<String,Object>params = new HashMap<>();
		String SQL = "SELECT code,name,email FROM users WHERE code=:code";
		params.put("code",code);
		User user = template.queryForObject(SQL, params,new UserMapper());
		return user;
	}

}
