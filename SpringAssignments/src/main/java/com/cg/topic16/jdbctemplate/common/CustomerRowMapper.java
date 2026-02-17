package com.cg.topic16.jdbctemplate.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

public class CustomerRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustId(rs.getInt("CUST_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getInt("AGE"));
		return customer;
	}
	
}
