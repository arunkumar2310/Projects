package edu.ksr.iet.prp.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.business.IETAttendance;

@WebServlet(name="show details",urlPatterns="/details")
public class IETShowAttendanceDetails extends HttpServlet {
   @Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String attendanceDate= req.getParameter("date");
	//System.out.println(d);
	/*SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/DD");
	Date attendanceDate=null;
	try {
		 attendanceDate= sdf.parse(d);
		 System.out.println("try");
		 System.out.println(attendanceDate);
	} catch (ParseException e) {
		e.printStackTrace();
	}*/
	System.out.println(attendanceDate);
	IETAttendance attendance=new IETAttendance();
	List<String> studentId=attendance.getAttendance(attendanceDate);
	req.setAttribute("studentlist", studentId);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/details.jsp");
	dispatcher.forward(req, resp);
}
	
}
