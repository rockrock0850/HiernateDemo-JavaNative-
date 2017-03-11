package employee.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import employee.hibernate.entity.Employee;
import employee.hibernate.utils.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> select() {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();

			List<Employee> employees = session.createQuery("from Employee").list();
			session.close();
			return employees;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee select(long id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();

			Employee employee = (Employee) session.get(Employee.class, id);
			session.close();
			return employee;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee insert(Employee employee) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Long id = (Long) session.save(employee);
			employee.setId(id);
			
			session.getTransaction().commit();
			session.close();
			return employee;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee update(Employee employee) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.merge(employee);
			
			session.getTransaction().commit();
			session.close();
			return employee;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Employee employee) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			
			session.delete(employee);
			
			session.getTransaction().commit();
			session.close();
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
