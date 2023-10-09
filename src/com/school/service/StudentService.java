package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);

	}

	public boolean deleteStudentById(int i) {

		return studentDao.deleteStudentById(i);

	}
}
