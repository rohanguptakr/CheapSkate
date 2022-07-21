package application;

import java.sql.*;

class DBUtils{
	static String username;
	static String password;
	static String email;
	static String f_name;
	static String l_name;
	public static int Checkinfo(String uname, String pass){ 
		Connection con = null;
		PreparedStatement pscheck = null;
		ResultSet rs = null;
		String fname; 
		String lname;
		String e_mail;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","123456");    
			pscheck = con.prepareStatement("select * from user_details where user_name = ?");
			pscheck.setString(1, uname);
			rs = pscheck.executeQuery();
			if(!rs.next()) {
				return 1;
			}
			pscheck = con.prepareStatement("select * from user_details where password = ?");
			pscheck.setString(1, pass);
			rs = pscheck.executeQuery();
			if(!rs.next()) {
				return 2;
			}
			username = uname;
			password = pass;
			fname = rs.getString(3);
			lname = rs.getString(4);
			e_mail = rs.getString(6);
			email = e_mail;
			f_name = fname;
			l_name = lname;
			Main m = new Main();
			m.changeScene("Homepage.fxml");
			con.close();
		}catch(Exception e){ System.out.println(e);} 
		return 0;
	}
	
	public static int Enterinfo(String fname, String lname, String uname, String pass, String e_mail) {
		Connection con = null;
		PreparedStatement psinsert = null;
		PreparedStatement pscheck = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","123456");    
			pscheck = con.prepareStatement("select * from user_details where user_name = ?");
			pscheck.setString(1, uname);
			rs = pscheck.executeQuery();
			if(rs.next()) {
				return 1;
			}
			psinsert = con.prepareStatement("insert into user_details(user_name, f_name, l_name, password, email) values(?,?,?,?,?)");
			psinsert.setString(1, uname);
			psinsert.setString(2, fname);
			psinsert.setString(3, lname);
			psinsert.setString(4, pass);
			psinsert.setString(5, e_mail);
			psinsert.executeUpdate();
			con.close();
			username = uname;
			password = pass;
			email = e_mail;
			f_name = fname;
			l_name = lname;
			Main m = new Main();
			m.changeScene("Homepage.fxml");
			con.close();
		}catch(Exception e){ System.out.println(e);} 
		return 0;
	}
} 