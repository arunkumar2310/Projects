package edu.ksr.iet.prp.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ksr.iet.prp.bean.Student;
import edu.ksr.iet.prp.dao.StudentDao;
import edu.ksr.iet.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	public StudentDaoImpl(){
		
	}
	

	@Override
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from students";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Student student = new Student();
				student.setStudentid(resultSet.getString("studentid"));
				student.setName(resultSet.getString("name"));
				student.setPhone(resultSet.getString("phone"));
				student.setEmail(resultSet.getString("email"));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, prepareStatement, resultSet);
		}
		return studentList;
	}	
	
	public void inserData(String fileName){
		List<String> list = readReader(fileName);
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;
		try {
		for (String line : list) {
			String studentElements[] = line.split(",");
			System.out.println(studentElements[0]);
			String sql = "insert into students values(?,?,?,?)";
				connection = DBUtil.getConnection();
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1,studentElements[0]);
				prepareStatement.setString(2, studentElements[1]);
				prepareStatement.setString(3, studentElements[2]);
				prepareStatement.setString(4, studentElements[3]);
				prepareStatement.executeUpdate();
		}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.close(connection, prepareStatement,resultSet);
		}
			
		
	}
	
	public List<String> readReader(String fileName){
		BufferedReader bufferReader = null; // declare
		 List<String> list = new ArrayList<String>();
		 String tmp = "";
		try{
			bufferReader = new BufferedReader(
				new FileReader(fileName)); //initialize
		
		 while((tmp = bufferReader.readLine()) != null){
			 list.add(tmp);
		 }
		 System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(bufferReader != null)
					bufferReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		StudentDaoImpl impl = new StudentDaoImpl();
		impl.inserData("D:\\MySql\\project\\prp1.csv");
	}
}









