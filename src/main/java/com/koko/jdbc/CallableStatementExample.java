package com.koko.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.koko.jdbc.utils.ConnectionManager;

public class CallableStatementExample {

	private static void callGetNameByIdFunction() {
		String sql = "{?= call getNameById(?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement callStmt = con.prepareCall(sql)) {
			
			callStmt.setInt(2, 100);
			
			// below method used to register data type of the out parameter
			callStmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			callStmt.execute();
			
			String output = callStmt.getString(1);
			System.out.println("The output returned from sql function: " + output);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		callGetNameByIdFunction();
	}

}
