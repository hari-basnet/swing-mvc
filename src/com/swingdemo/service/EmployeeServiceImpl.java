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
		
		String sql = "update employee set first_name=?, last_name=?, age=?, gender=?, email=?, phone_number=?, country=?, company=?, address=?, city=?, post=?, date_of_birth=?, joined_at=?, salary=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setInt(3, emp.getAge());
			pstmt.setString(4, emp.getGender());
			pstmt.setString(5, emp.getEmail());
			pstmt.setString(6, emp.getPhoneNumber());
			pstmt.setString(7, emp.getCountry());
			pstmt.setString(8, emp.getCompany());
			pstmt.setString(9, emp.getAddress());
			pstmt.setString(10, emp.getCity());
			pstmt.setDate(11, (Date) emp.getDob());
			pstmt.setDate(12, (Date) emp.getJoiningDate());
			pstmt.setInt(13, emp.getId());
			
			pstmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Employee getById(int id) {
		Employee  emp = new Employee();

		String sql ="select * from employee where id = "+id;
		try {
			Statement stm = conn.createStatement();
			ResultSet  rs = stm.executeQuery(sql);

			if(rs.next()) {

				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setAge(rs.getInt("age"));
				emp.setGender(rs.getString("gender"));
				emp.setCompany(rs.getString("company"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setAddress(rs.getString("address"));
				emp.setCity(rs.getString("city"));
				emp.setCountry(rs.getString("country"));
				emp.setPost(rs.getString("psot"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDob(rs.getDate("date_of_birth"));
				emp.setJoiningDate(rs.getDate("joined_at"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
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
				
				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setCountry(rs.getString("country"));
				
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
