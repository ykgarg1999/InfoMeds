package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Index_dao;

/*
 * Servlet implementation class Reg_ser
 */
@WebServlet("/reg")
public class Reg_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_ser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=request.getParameter("fname");
		String mail=request.getParameter("mail");
		String uname=request.getParameter("uname");
		String pword=request.getParameter("pword");
		Index_dao reg_obj = new Index_dao();
		String reg_ob = reg_obj.reg(fname,mail,uname,pword);
		if(reg_ob=="areg") {
			RequestDispatcher rd=request.getRequestDispatcher("/signup.html");
			rd.forward(request, response);
			
		}
		else if(reg_ob=="reg") {
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/fail.jsp");
			rd.forward(request, response);
		}
		
		

	}

}
