package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class SearchService {

	public List<Customer> searchCustomer (String gender, String blood) {
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "select * from customer where gender =? and blood=?;";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gender);
			ps.setString(2, blood);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBlood(rs.getString("blood"));
				customer.setOld(rs.getInt("old"));
				customerList.add(customer);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	public List<Customer> searchId (int id) {
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "select * from customer where id =?;";
		List<Customer> customerList2 = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBlood(rs.getString("blood"));
				customer.setOld(rs.getInt("old"));
				customer.setMemo(rs.getString("memo"));
				customerList2.add(customer);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList2;
	}

}
