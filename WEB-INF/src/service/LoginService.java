package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

	public String login (String email, String password) {
		//DB接続情報
		String dbName = "system_user";
		String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl = "jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser = "root";
		String dbPassword = "admin";
		String sql = "select name from customer where email =? and password=?;";
		try {
			//MySQLに接続する
			Class.forName("com.mysql.jdbc.Driver");
			//データベースに接続
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			//変数sqlのクエスチョンマーク？に代入する値をセットする
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			//SQL実行
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//loginテーブルから取得した名前を返却する
				String name = rs.getString("name");
				return name;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
}
