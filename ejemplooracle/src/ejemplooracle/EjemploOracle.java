package ejemplooracle;

import java.sql.*;

public class EjemploOracle {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:oracle:thin:ipartek/ipartek@localhost:1521/XE";
		
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		
		String sql = "SELECT * FROM USUARIOS";
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
			System.out.println(rs.getString(2));
	}

}
