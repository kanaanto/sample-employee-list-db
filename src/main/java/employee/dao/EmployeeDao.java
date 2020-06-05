package employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employee.model.Employee;

@Repository
public class EmployeeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getEmployeeList() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery(" from Employee").list();
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		return new Employee();
	}

	@Transactional
	public void addEmployee(Employee newEmp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(newEmp);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);
	}

	@Transactional
	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if (null != emp) {
			session.delete(emp);
		}
	}
}
