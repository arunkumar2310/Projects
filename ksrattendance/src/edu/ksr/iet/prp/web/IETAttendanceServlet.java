package edu.ksr.iet.prp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.business.IETAttendance;
import edu.ksr.iet.prp.bean.Student;

@WebServlet(name="attn",urlPatterns="/list")
public class IETAttendanceServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IETAttendance attendace = new IETAttendance();
		List<Student> studentList = attendace.getStudents();
		req.setAttribute("stulist", studentList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
		dispatcher.forward(req, resp);
	}
}







