package com.koko.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.koko.jdbc.utils.ConnectionManager;

public class SelectRecordsExample {

	private static void selectEmployees() {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME from employees";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String employeeName = rs.getString("FIRST_NAME");
				System.out.println("employeeId : " + employeeId + "  employeeName :" + employeeName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		selectEmployees();
	}

}
