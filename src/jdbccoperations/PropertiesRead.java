package jdbccoperations;


import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesRead {
	public static void main(String[] args) {
		try {
			FileOutputStream fileoutputStream=new FileOutputStream("directory.properties");
			Properties properties=new Properties();
			properties.setProperty("100","Suresh");
			properties.setProperty("200","raman");
			properties.setProperty("300","akash");
			properties.store(fileoutputStream, "my first properties file");
			System.out.println("Data Inserted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
