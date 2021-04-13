package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class ConfirmService {

	public List<Customer> confirmCustomer (String email, String password, String name, String gender, String blood, int old, String memo) {
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "insert into customer (email, password, name, gender, blood, old, memo) value (?, ?, ?, ?, ?, ?, ?);";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, gender);
			ps.setString(5, blood);
			ps.setInt(6, old);
			ps.setString(7, memo);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}
}
