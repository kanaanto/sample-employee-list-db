package employee;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String listPersons(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeService.getEmployeeList());
		return "index";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee emp) {
		if (emp.getId() == 0) {
			employeeService.addEmployee(emp);
		} else {
			employeeService.updateEmployee(emp);
		}
		return "redirect:/";
	}

	@RequestMapping("/employee/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("employeeList", employeeService.getEmployeeList());
		model.addAttribute("type", "add");
		return "index";
	}

	@RequestMapping("/employee/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "login";
	}
}
