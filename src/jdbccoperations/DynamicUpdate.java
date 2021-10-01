package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DynamicUpdate {
	public static void main(String[] args) {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id:");
		int id=sc.nextInt();
		System.err.println("Enter the name:");
		String name=sc.next();
		System.out.println("Enter the salary:");
		Double sal=sc.nextDouble();
		
		System.out.println("Enter the id for delete the data:");


		String dbUrl="jdbc:mysql://localhost:3306/demo?user=root&password=root";
		try {
			connection=DriverManager.getConnection(dbUrl);
			String query="update emp set name=?,salary=? where id=?";
			
			String query1="delete from emp where id=?";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(3, id);
			preparedStatement.setDouble(2, sal);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.out.println("Costly resources closed!!!");
			}
		}
	}
}
