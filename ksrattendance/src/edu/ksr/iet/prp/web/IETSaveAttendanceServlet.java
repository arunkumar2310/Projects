package edu.ksr.iet.prp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.business.IETAttendance;

@WebServlet(name="saveattn",urlPatterns="/attn")
public class IETSaveAttendanceServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s[] = req.getParameterValues("present");
		List<String> studentIdList = new ArrayList<String>();
		for (String val : s) {
			System.out.println(val);
			studentIdList.add(val);
		}
		IETAttendance attendace = new IETAttendance();
		attendace.putAttendance(studentIdList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/confirmattendance.jsp");
		dispatcher.forward(req, resp); 
	}

}







