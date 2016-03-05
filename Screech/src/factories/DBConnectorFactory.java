package factories;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConnectorFactory {
	private static java.sql.Connection con = null;
	
	public static java.sql.Connection getDatabaseConnection() {
		if (con == null) {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("password");
			ds.setUrl("jdbc:mysql://localhost:3307/screechdatabase");
			try {
				con=ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}

}
