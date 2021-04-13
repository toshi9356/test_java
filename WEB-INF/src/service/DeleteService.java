package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class DeleteService {

	public List<Customer> deleteCustomer (int id) {
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "delete from customer where id = ?;";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}
}
