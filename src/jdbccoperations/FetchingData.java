package jdbccoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchingData {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from emp where id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id ??");
		int id=sc.nextInt();
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString(2);
				Double per=rs.getDouble(3);
				System.out.println(name+" "+per);
			}else {
				System.out.println("No data found for Id"+id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}
}

