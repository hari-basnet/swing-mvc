package com.swingdemo.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swingdemo.db.Database;
import com.swingdemo.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	Connection conn = null;
	
	
	
	public EmployeeServiceImpl() {
		conn = Database.createConnection();
	}

	@Override
	public boolean addEmp(Employee emp) {
		
		String sql = "INSERT into employee(first_name, last_name, age, gender, email, company, country, address, city, post, phone_number, date_of_birth, joined_at, salary)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setInt(3, emp.getAge());
			pstmt.setString(4, emp.getGender());
			pstmt.setString(5, emp.getEmail());
			pstmt.setString(6, emp.getCompany());
			pstmt.setString(7, emp.getCountry());
			pstmt.setString(8, emp.getAddress());
			pstmt.setString(9, emp.getCity());
			pstmt.setString(10, emp.getPost());
			pstmt.setString(11, emp.getPhoneNumber());
			pstmt.setDate(12, (Date) emp.getDob());
			pstmt.setDate(13, (Date) emp.getJoiningDate());
			pstmt.setInt(14, emp.getSalary());

			pstmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmp(int id) {
		return false;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		return false;
	}

	@Override
	public Employee getById(int id) {
		return null;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * from employee";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber("phone_number");
				emp.setCountry(rs.getString("country"));
				emp.setPost(rs.getString("post"));
				
				employees.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public List<Employee> search(String input) {
		return null;
	}

}
