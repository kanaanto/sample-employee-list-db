package employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employee.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getEmployeeList() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery(" from Employee").list();
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		return p;
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
