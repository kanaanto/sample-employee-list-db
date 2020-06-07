package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import employee.model.Login;
import employee.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		boolean isValidUser = true;// login.getUsername().equals("admin") &&
									// login.getPassword().equals("admin");//
									// loginService.validateUser(login);
		if (isValidUser) {
			mav = new ModelAndView("redirect:/");
			session.setAttribute("username", login.getUsername());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Invalid username and/or password");
		}
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/login";
	}
}