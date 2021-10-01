package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaticRead {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String qry="select * from emp";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded");
			String dburl="jdbc:mysql://localhost:3306/demo";
			connection =DriverManager.getConnection(dburl,"root","root");
			statement=connection.createStatement();
			String query="select * from emp";
			resultSet=statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Id:"+resultSet.getInt(1));
				System.out.println("Name"+resultSet.getString(2));
				System.out.println("Location"+resultSet.getString(3));
				System.out.println("Salary"+resultSet.getDouble(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.out.println("Closed CostlyResources");
			}
		}
	}
}
