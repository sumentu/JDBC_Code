package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataStudent {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into studentdetails values(101,'Sumentu',Jamshedpur',8368139)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Loaded & Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DataBase Server");

			stmt=con.createStatement();
			System.out.println("Platform Created");

			stmt.execute(qry);
			System.out.println("Data Inserted");

		} catch ( Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("close costly resources");
		}
	}
}
