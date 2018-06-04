package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -756208604967516279L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//PrintWriter pw = resp.getWriter();
		//pw.write("<p>hello from the <strong> Calculator servlet</strong></p>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//obtain req params
		Double n1 = Double.parseDouble(req.getParameter("n1"));
		Double n2 = Double.parseDouble(req.getParameter("n2"));
		String operation = req.getParameter("operation");
		Double answer = 0.0;
		switch(operation) {
		
		case "add":
			answer = n1+n2;
			break;
		case "subtract":
			answer = n1-n2;
			break;
		case "multiply":
			answer = n1*n2;
			break;
		case "divide":
			answer = n1/n2;
			break;
	
		}
//		//include answer in response
//		PrintWriter pw = resp.getWriter();
//		pw.write(answer.toString());
//		//or forward request to an answer servlet
//		req.setAttribute(arg0, arg1);
		
		RequestDispatcher rd = req.getRequestDispatcher("answer");
		rd.forward(req, resp);
		//pw.write("<p>hello from the <strong> Calculator servlet</strong></p>");
		
	}
}
