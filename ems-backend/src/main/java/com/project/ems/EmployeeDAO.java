package com.project.ems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemp;

	
	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS Employees(emp_id INT PRIMARY KEY, name VARCHAR2(200), email_id VARCHAR2(100))";
		int status = this.jdbcTemp.update(query);
		return status;
	}
	
	public int insert(Employee e) {
		String query = "INSERT INTO Employees(name, email) VALUES (? ,?);";
		return jdbcTemp.update(query, new Object[] {e.getName(), e.getEmail()});
	}
	
	public int update(Employee e, int id) {
		String query = "UPDATE Employees SET name=?, email=? WHERE id=?;";
		return jdbcTemp.update(query, new Object[] {e.getName(), e.getEmail(), id});
	}
	
	public List<Employee> getAll() {
		String query = "SELECT * FROM Employees;";
		return jdbcTemp.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee getById(int id) {
		String query = "SELECT * FROM Employees WHERE id=?;";
		return jdbcTemp.queryForObject(query, new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}
	
	public Employee getByEmail(String email) {
		String query = "SELECT * FROM Employees WHERE email=?;";
		return jdbcTemp.queryForObject(query, new BeanPropertyRowMapper<Employee>(Employee.class), email);
	}
	
	public int delete(int id) {
		String query = "DELETE FROM Employees WHERE id=?;";
		return jdbcTemp.update(query, id);
	}
}
