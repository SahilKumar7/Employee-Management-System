package com.project.ems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao;

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		return dao.getAll();
	}
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return dao.getById(id);
	}
	
	@GetMapping("/api/employee-email/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
		return dao.getByEmail(email);
	}

	@PostMapping("/api/add-employee")
	public String addEmployee(@RequestBody Employee e) {
		return "No. of rows inserted: "  + dao.insert(e);
	}
	
	@PutMapping("/api/update-employee/{id}")
	public String updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		return "No. of rows affected: " + dao.update(e, id);
	}
	
	@DeleteMapping("/api/delete-employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return "No. of rows deleted: " + dao.delete(id);
	}
	
//	@DeleteMapping("/api/del-employee/{email}")
//	public String deleteEmployee(@PathVariable String email) {
//		return "No. of rows deleted: " + dao.delete(email);
//	}
}
