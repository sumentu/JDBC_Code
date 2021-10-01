package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DynamicAutoClosable {
public static void main(String[] args) {
	try (Connection connection=DriverManager.getConnection("dbUrl");
			Statement statement=connection.createStatement();
			)catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
