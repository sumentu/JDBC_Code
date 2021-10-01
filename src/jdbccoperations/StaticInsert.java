package jdbccoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StaticInsert {
	public static void main(String[] args) {
		Connection connection= null;
		Statement statement= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/demo?user=root&password=root";
	
			
			System.out.println("Connections Stablished Successfully");

			connection= DriverManager.getConnection(dbUrl);
			String query1="insert into emp values(19,'Akash','punjab',10000)";
			String query2="insert into emp values(12,'suresh','kolkata',30000)";
			String query3="insert into emp values(13,'nisha','mumbai',20000)";
			String query4="insert into emp values(14,'priti','hyderabad',70000)";
			String query5="insert into emp values(15,'daksh','bangalore',40000)";

			statement =connection.createStatement();
			int result1=statement.executeUpdate(query1);
			int result2=statement.executeUpdate(query2);
			int result3=statement.executeUpdate(query3);
			int result4=statement.executeUpdate(query4);
			int result5=statement.executeUpdate(query5);


		} catch (Exception e ) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.out.println("cose costly resources");
			}

		}
	}
}
