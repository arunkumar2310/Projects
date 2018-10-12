package edu.ksr.iet.business;

import java.sql.Date;
import java.util.List;

import edu.ksr.iet.prp.bean.Student;
import edu.ksr.iet.prp.dao.AttendanceDao;
import edu.ksr.iet.prp.dao.StudentDao;
import edu.ksr.iet.prp.dao.impl.AttendanceDaoImpl;
import edu.ksr.iet.prp.dao.impl.StudentDaoImpl;

public class IETAttendance {
	
	StudentDao studentDao;
	AttendanceDao attendanceDao;
	public IETAttendance(){
		studentDao = new StudentDaoImpl();
		attendanceDao = new AttendanceDaoImpl();
	}
	
	public List<Student> getStudents(){
		return studentDao.getStudents();
	}
	public int putAttendance(List<String> studentIdList){
		return attendanceDao.insertAttendance(studentIdList);
	}
	public List<String> getAttendance(String attendanceDate){
		return attendanceDao.getAttendance(attendanceDate);
	}
}
