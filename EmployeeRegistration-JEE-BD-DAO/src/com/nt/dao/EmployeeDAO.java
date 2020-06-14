package com.nt.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.nt.bo.BaseEmployeeBO;

public interface EmployeeDAO {
	
	public int   insert(BaseEmployeeBO  bo,Connection con)throws SQLException;

}
