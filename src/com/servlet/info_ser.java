package com.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Index_dao;
import com.dao.med_ret;

/**
 * Servlet implementation class info_ser
 */
@WebServlet("/submit")
public class info_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info_ser() {
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
		String med=request.getParameter("srch");
		Index_dao dao=new Index_dao();
		med_ret s=dao.check(med);
		if(s!=null) {
			
			request.setAttribute("drg", s);
			RequestDispatcher rd=request.getRequestDispatcher("/med_info.jsp");
			rd.forward(request, response);
			
			
			
		}
		else {
			response.sendRedirect("index.html");
		}

	}

}
