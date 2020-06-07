package employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import employee.dao.EmployeeDao;
import employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		employeeDao.addEmployee(emp);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

}
