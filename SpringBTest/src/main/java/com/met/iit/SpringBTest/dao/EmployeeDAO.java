package com.met.iit.SpringBTest.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.met.iit.SpringBTest.model.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveUsingJdbcTemplate(Employee emp) {
		
		jdbcTemplate.update("insert into employee values (?, ?, ?, ?)", 
			new Object[] {emp.getId(), emp.getName(), emp.getEmailId(), emp.getDesignation()});
		
		
	}
	
	
public  Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select * from employee", 
				
					new BeanPropertyRowMapper<Employee>(Employee.class)
					//new EmployeeMapper()
				
				);
		
		
	}

}
