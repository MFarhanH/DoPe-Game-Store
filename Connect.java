package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "dope_gamestore";
	private final String HOST = "localhost:3306";
	
	private final String CONNECTION =
			String.format("jdbc:mysql://%s/%s",HOST, DATABASE);
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	
	//design pattern
	//singleton = fokus ke 1 object class only
	
	private static Connect instance = null;
	
	public static Connect getInstance() {
		if(instance == null) instance = new Connect();
		return instance;
	}
	
	private Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error conncet DB");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public ResultSet executeQuery(String query) {
		rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//excute Update -> inser update delete
	//kita pake yang pas update bisa ngeliat
	public int executeUpdate(String query) {
		try {
			return st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public PreparedStatement preparedStatement(String query) {
		ps = null;
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
