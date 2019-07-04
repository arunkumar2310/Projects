package edu.ksr.iet.prp.dao;

import java.sql.Date;
import java.util.List;

import edu.ksr.iet.prp.bean.Student;

public interface AttendanceDao {
	
	public int insertAttendance(List<String> studentIdsList);
	public List<String> getAttendance(String attendanceDate);
}
