package com.school.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.school.configuration.HelperClass;
import com.school.dto.Student;
import java.sql.Connection;

public class StudentDao {

	HelperClass helperClass = new HelperClass();
	Connection connection = null;

	// to delete a student

	public boolean deleteStudentById(int id) {

		connection = helperClass.getConnection();
		String sql = "DELETE FROM student WHERE id=?";
		int i = 0;

		// establish my statement
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	// to save a student data
	public Student saveStudent(Student student) {
		connection = helperClass.getConnection();
		String sql = "INSERT INTO student VALUES(?,?,?)";// ? is place holder or delimiter
		// create statement
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// passed the values to delimiter
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());

			// execute
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
}
