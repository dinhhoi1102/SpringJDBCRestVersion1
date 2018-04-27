package com.hoi1102.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoi1102.model.Employee;
import com.hoi1102.service.EmployeeService;

@RestController

public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	/* ---------------- GET ALL USER ------------------------ */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Employee>> getAllUser() {
		// System.out.println(mapUser.values());
		List<Employee> listEmployee = new ArrayList<Employee>(employeeService.findAll());
		System.out.println(listEmployee);

		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	/* ---------------- GET USER BY ID ------------------------ */
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id) {
//		List<Employee> listEmployee = new ArrayList<Employee>(employeeService.findAll());
//		for (int i = 0; i < listEmployee.size(); i++) {
//			if (listEmployee.get(i).getId() == id) {
//				return new ResponseEntity<Object>(listEmployee.get(i), HttpStatus.OK);
//			}
//		}
		// Employee user = listEmployee.get(id);
//		employeeService.findById(id);
		
		return new ResponseEntity<Object>(employeeService.findById(id), HttpStatus.OK);
	
		
	}

	/* ---------------- CREATE NEW USER ------------------------ */
	@PostMapping(value = "/users")
	public ResponseEntity<String> createUser(@RequestBody Employee employee) {
		List<Employee> listEmployee = new ArrayList<Employee>(employeeService.findAll());
		// if (listEmployee.containsKey(employee.getId())) {
		// return new ResponseEntity<String>("User Already Exist!",
		// HttpStatus.CONFLICT);
		// }

		employeeService.save(employee);
		return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
	}

	/* ---------------- DELETE USER ------------------------ */
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		List<Employee> listEmployee = new ArrayList<Employee>(employeeService.findAll());

		Employee employee = listEmployee.get(id);
		if (employee == null) {
			return new ResponseEntity<String>("Not Found ", HttpStatus.OK);
		}

		employeeService.delete(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

	/* ---------------- UPDATE USER ------------------------ */
	@PutMapping(value = "/users")
	public ResponseEntity<String> updateUser(@RequestBody Employee employee) {
		List<Employee> listEmployee = new ArrayList<Employee>(employeeService.findAll());

		// Employee oldUser = listEmployee.get(employee.getId());
		// if (oldUser == null) {
		// return new ResponseEntity<String>("Not Found ", HttpStatus.NO_CONTENT);
		// }

		// replace old user by new user.
		employeeService.update(employee);
		return new ResponseEntity<String>("Updated!id new =" + employee.getName() + "idold=", HttpStatus.OK);
	}

}
