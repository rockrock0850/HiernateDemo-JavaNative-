package employee.hibernate.main;

import java.util.Date;
import java.util.List;

import employee.hibernate.dao.EmployeeDao;
import employee.hibernate.dao.EmployeeDaoImpl;
import employee.hibernate.entity.Employee;
import employee.hibernate.utils.ShareTool;

public class EmployeeHibernate {
	private static EmployeeDao employeeDao = new EmployeeDaoImpl();

	public static void main(String[] args) {
		
		/*
		 * READ
		 */
		
		System.out.println("******* READ *******");
		List<Employee> employeeList = employeeDao.select();
		System.out.println("LIST: " + ShareTool.toStringBuilder(employeeList));
		System.out.println();
		
		Employee employee;
		
		/*
		 * INSERT
		 */
		
		System.out.println("******* INSERT *******");
		employee = new Employee("Adam", "Yeh", new Date(), "911");
		employee = employeeDao.insert(employee);
		employee = employeeDao.select(employee.getId());
		System.out.println("INSERT: " + ShareTool.toStringBuilder(employee));
		System.out.println();
		
		/*
		 * UPDATE
		 */
		
		System.out.println("******* UPDATE *******");
		long id = 41;
		employee = employeeDao.select(id);
		employee.setFirstName("Bibert");
		employee = employeeDao.update(employee);
		System.out.println("UPDATE: " + ShareTool.toStringBuilder(employee));
		System.out.println();
		
		/*
		 * DELETE
		 */
		
		System.out.println("******* DELETE *******");
		employeeDao.delete(employee); 
		System.out.println("DELETE: " + ShareTool.toStringBuilder(employee));
	}
}
