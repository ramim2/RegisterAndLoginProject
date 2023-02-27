package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String path=request.getServletPath();
		switch(path) 
		{
		case "/logCustomer":
			validatecustomer(request,response);
			break;
		case"/regcustomer":
			insertCustomer(request,response);
		case"/reg":
		    getRegistrationPage(request,response);
			break;
		case"/log":
			getLoginPage(request,response);
			
		default:
		    getStartUpPage(request,response);
		    break;
		}
	}

	private void validatecustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		
		String email=request.getParameter("tbemail");
		String password=request.getParameter("tbpass");
		
		boolean res=DataAccess.validateCustomer(email,password);
		if(res) {
			 try {
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				//store the successpage class data in store requestdispatcher//
					SuccessPage sp=new SuccessPage();
					request.setAttribute("succesDetails",sp);
					
					rd.forward(request, response);
				  } 
				catch (IOException e1) {
					
					e1.printStackTrace();
				  }
			    catch(ServletException e1) 
		          {
				    e1.printStackTrace();
			      }
		        }
		else {
			getLoginPage(request,response);
			
		      }
			
		}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String n=request.getParameter("tbname");
		String e=request.getParameter("tbemail");
		long m=Long.parseLong(request.getParameter("tbMobile"));
	    String s=request.getParameter("ddlStates");
		String p=request.getParameter("tbpass");
		
		Customer c=new Customer(n,e,m,s,p);
		
		DataAccess.insertCustomer(c);
		 try {
				RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			
				rd.forward(request,response);
			  } 
			catch (IOException e1){
				
				e1.printStackTrace();
			  }
		    catch(ServletException e1) 
	          {
			    e1.printStackTrace();
		      }
		 catch(NumberFormatException e1) {
			 e1.printStackTrace();
			 
		 }
	}
		
	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		  try {
				RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
			
				rd.forward(request, response);
			  } 
			catch (IOException e)
		       {
				e.printStackTrace();
			   }
		    catch(ServletException e) 
	          {
			    e.printStackTrace();
		      }
		  catch(NumberFormatException e) {
				 e.printStackTrace();
		 
		}
	}
		
	private void getLoginPage(HttpServletRequest request, HttpServletResponse response)
	{
		  try {
				RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			
				rd.forward(request, response);
			   } 
			catch (IOException e) {
				
				e.printStackTrace();
			   }
		    catch(ServletException e) 
	           {
			    e.printStackTrace();
		}
	}
		
	

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
      try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
		
			rd.forward(request, response);
		   } 
		catch (IOException e) {
			
			e.printStackTrace();
		   }
	   catch(ServletException e) 
           {
		e.printStackTrace();
	      }
	}
	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
