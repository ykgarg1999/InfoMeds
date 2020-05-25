package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Index_dao {
	
	String url = "jdbc:mysql://localhost:3306/infomeds?serverTimezone=UTC";
	String username="root";
	String pass= "";
	private med_ret med_info = new med_ret();
	public med_ret check(String med) {
		String sql = "select * from drugs_data where drug_name = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,pass);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1,med);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				med_info.setId(rs.getInt(1));
				med_info.setDrg_nam(rs.getString(2));
				med_info.setCond(rs.getString(3));
				med_info.setRev(rs.getString(4));
				med_info.setRat(rs.getInt(5));
								
				return med_info;
				
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	
			return med_info;
		
		
		
	}
	
	public String reg(String fname,String mail,String uname,String pword) {
		  String sql1 = "Select mail from Register where mail=?";
          String sql2 = "Insert into Register values (?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,pass);
			PreparedStatement st_c= con.prepareStatement(sql1);
			st_c.setString(1, mail);
			System.out.println("1");
			ResultSet rs_c=st_c.executeQuery();
			if(rs_c.next()) {
				return "areg";
			}
			else {
				PreparedStatement st= con.prepareStatement(sql2);
				st.setString(1,fname);
				st.setString(2,mail);
				st.setString(3,uname);
				st.setString(4,pword);
				st.executeUpdate();
				return "reg";

				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "no";

		
		
	}

}
