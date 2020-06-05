package employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import employee.dao.EmployeeDao;
import employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Employee> getEmployeeList() {
		return dao.getEmployeeList();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		dao.addEmployee(emp);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

}
