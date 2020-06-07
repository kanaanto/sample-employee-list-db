package employee.service;

import org.springframework.beans.factory.annotation.Autowired;

import employee.dao.LoginDao;
import employee.model.Login;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean validateUser(Login login) {
		return loginDao.validateUser(login);
	}

}
