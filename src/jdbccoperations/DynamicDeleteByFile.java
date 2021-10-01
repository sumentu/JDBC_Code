package jdbccoperations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DynamicDeleteByFile {
	public static void main(String[] args) {

		Properties properties=new Properties();
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Values for delete into dataBase....");
		System.out.println();
		System.out.println("Enter the Id:");
		int id=sc.nextInt();
		sc.close();
		try {
			FileInputStream fileInputStream=new FileInputStream("resource.properties");
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"));
			preparedStatement = connection.prepareStatement(properties.getProperty("Deletequery"));
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Data deleted successfully");
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
