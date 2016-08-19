package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	Connection con;
	PreparedStatement pst;
	public void getDBConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"nidhi","password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void close(){
			try{
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		public void addCustomer(String name,String email,String password,long phone,long zip){
			getDBConnection();
			try {
				pst=con.prepareStatement("insert into customer values(seq1,?,?,?,?,?,?,?)");
				pst.setString(2,name);
				pst.setString(3,email);
				pst.setString(4,password);
				pst.setLong(5, phone);
				double lat=0;double lon=0;
				pst.setDouble(6, lat);
				pst.setDouble(7, lon);
				
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		


}
