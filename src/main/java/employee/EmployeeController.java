package employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService service;

	@Autowired(required = true)
	@Qualifier(value = "service")
	public void setEmployeeService(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String listPersons(Model model) {
		model.addAttribute("employeeList", this.service.getEmployeeList());
		return "index";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee emp) {
		this.service.addEmployee(emp);
		return "redirect:/index";
	}

	@RequestMapping("/employee/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.service.getEmployeeById(id));
		model.addAttribute("listPersons", this.service.getEmployeeList());
		return "redirect:/index";
	}

	@RequestMapping("/employee/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.service.deleteEmployee(id);
		return "redirect:/index";
	}
}
