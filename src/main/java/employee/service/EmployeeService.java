package employee.service;

import java.util.List;

import employee.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeeList();

	public Employee getEmployeeById(int id);

	public void addEmployee(Employee emp);

	public void updateEmployee(Employee empt);

	public void deleteEmployee(int id);
}
