package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class UpdateService {

	public List<Customer> updateCustomer (String email, String password, String name, String gender, String blood, String memo, int id) {
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "update customer set email =?, password =?, name =?, gender =?, blood =?, memo =? where id = ?;";
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
			ps.setString(6, memo);
			ps.setInt(7, id);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}
}
