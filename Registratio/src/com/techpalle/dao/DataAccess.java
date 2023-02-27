package com.techpalle.dao;
import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess 
{
	private static final String dburl="jdbc:mysql://localhost:3306/jdbc";
	private static final String dbusername="root";
	private static final String dbpassword="rootpassword";
	
	private static Connection con=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into student3(name,email,mobile,state,password)values(?,?,?,?,?)";
	private static final String validateQry="select email,password from student3 where email=? and password=?";
	
	
	
	public static boolean validateCustomer(String email,String password) 
	{
		boolean b=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			ps=con.prepareStatement(validateQry);
			ps.setString(1,email);
			ps.setString(2,password);
			
		    rs=ps.executeQuery();
			b=rs.next();
	}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally {
			try 
			{
			if(rs!=null) 
			{
				rs.close();
			}
			if(ps!=null) 
			{
				ps.close();
			}
			if(con!=null) 
			{
			   con.close();
			}
		    }
		       catch(SQLException e)
		    {
				e.printStackTrace();
			}
		}
		return b; 
	}
	
	
	
	public static void insertCustomer(Customer customer) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			ps=con.prepareStatement(insertQry);
			
			ps.setString(1,customer.getName());
			ps.setString(2,customer.getEmail());
			ps.setLong  (3,customer.getMobile());
			ps.setString(4,customer.getState());
			ps.setString(5,customer.getPassword());
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally {
			try 
			{
			if(ps!=null) 
			{
				ps.close();
			}
			if(con!=null) 
			{
				con.close();
			}
		    }
		       catch(SQLException e)
		    {
				e.printStackTrace();
			}
		}
	}
	

}
      



