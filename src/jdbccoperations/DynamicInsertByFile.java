package jdbccoperations;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DynamicInsertByFile {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Properties properties = new Properties();
//		try {
//			FileOutputStream fileOutputStream = new FileOutputStream("resource.properties");
//			properties.setProperty("dbUrl", "jdbc:mysql://localhost:3306/demo?user=root&password=root");
//			properties.store(fileOutputStream, "file created and data stored");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Id: ");
		int id = scanner.nextInt();
		System.out.println("Enter the name: ");
		String name = scanner.next();
		System.out.println("Enter the percentage: ");
		double perc = scanner.nextDouble();
		scanner.close();
	
		try {
			FileInputStream fileInputStream = new FileInputStream("resource.properties");
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"));
			preparedStatement = connection.prepareStatement(properties.getProperty("Insertquery"));
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
