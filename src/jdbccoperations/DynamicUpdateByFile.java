package jdbccoperations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DynamicUpdateByFile {
	public static void main(String[] args) {

		Properties properties=new Properties();
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		//		try {
		//			FileOutputStream fileOutputStream=new FileOutputStream("resource.properties");
		//			properties.setProperty("dbUrl","jdbc:mysql://localhost:3306/demo?user=root&password=root");
		//			properties.store(fileOutputStream, "file updated");
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Values for Update into dataBase....");
		System.out.println();
		System.out.println("Enter the Id:");
		int id=sc.nextInt();
		System.out.println("Enter name :");
		String name=sc.next();
		System.out.println("Enter percentage:");
		Double perc=sc.nextDouble();
		sc.close();

		try {
			FileInputStream fileInputStream=new FileInputStream("resource.properties");
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"));
			preparedStatement = connection.prepareStatement(properties.getProperty("Updatequery"));
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, perc);
			preparedStatement.executeUpdate();
			System.out.println("Data inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
