package com.sarthak.app.dao;

import com.sarthak.app.jdbc.DBConnection;
import com.sarthak.app.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
	
	@Override
	public void addStudent(Student student) {
		String sql = "INSERT INTO student(id, name, age, email, course) VALUES(?,?,?,?,?)";
		
		try (Connection con = DBConnection.getConnection();
		PreparedStatement ps  = con.prepareStatement(sql)) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getCourse());
			
			ps.executeUpdate();
			
			System.out.println("Student added sucessfully");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		
		String sql="SELECT * FROM student";
		
		try(Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
					
					while(rs.next()) {
						Student s = new Student();
		                s.setId(rs.getInt("id"));
		                s.setName(rs.getString("name"));
		                s.setAge(rs.getInt("age"));
		                s.setEmail(rs.getString("email"));
		                s.setCourse(rs.getString("course"));
		                list.add(s);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
		return list;
		
	}

	@Override
	public Student getStudentById(int id) {
		 String sql = "SELECT * FROM student WHERE id=?";
	        Student s = null;

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                s = new Student();
	                s.setId(rs.getInt("id"));
	                s.setName(rs.getString("name"));
	                s.setAge(rs.getInt("age"));
	                s.setEmail(rs.getString("email"));
	                s.setCourse(rs.getString("course"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return s;
	    }

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE student SET id=?, name=?, age=?, email=?, course=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getCourse());
            ps.setInt(6, student.getId());

            ps.executeUpdate();
            System.out.println(" Student updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM student WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected>0) {
            System.out.println(" Student deleted");
            } else {
            	System.out.println("Student not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
