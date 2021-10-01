package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;

public class GrossaryProducts {
public static void main(String[] args) {
	Connection con=null;
	String qry="insert into grossay values(?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Class Loaded & Register");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
