package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DyanamicInsert {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id: ");
		int id=sc.nextInt();
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter the city: ");
		String loc=sc.next();
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String dbUrl="jdbc:mysql://localhost:3306/demo?user=root&password=root";
		try {
			connection=DriverManager.getConnection(dbUrl);
			String query="insert into emp values(?,?,?)";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.out.println("clostly resources closed");
			}
		}

	}
}
