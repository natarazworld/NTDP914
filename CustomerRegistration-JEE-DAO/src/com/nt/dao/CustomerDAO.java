package com.nt.dao;

import java.sql.SQLException;

import com.nt.bo.CustomerBO;

public interface CustomerDAO {
	
	public   int  insert(CustomerBO bo)throws SQLException;

}
