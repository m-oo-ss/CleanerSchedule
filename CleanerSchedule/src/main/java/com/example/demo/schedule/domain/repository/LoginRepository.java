package com.example.demo.schedule.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(String name, String pass) {

		// SELECT文
		String query = "SELECT "
				+ " staff_id,"
				+ " staff.staff_name,"
				// + " staff_address, "
				// + " staff_mail, "
				// + " staff_tel, "
				+ " staff.staff_pass "
				+ "FROM staff "
				+ "WHERE staff.staff_name=?";

		try {

		// 検索実行
		Map<String, Object> staff = jdbcTemplate.queryForMap(query, name);

		return staff;

		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
