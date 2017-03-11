package employee.hibernate.dao;

import java.util.List;

import employee.hibernate.entity.Employee;

public interface EmployeeDao {
	public List<Employee> select();
	
	public Employee select(long id);
	
	public Employee insert(Employee employee);
	
	public Employee update(Employee employee);
	
	public boolean delete(Employee employee);
}
