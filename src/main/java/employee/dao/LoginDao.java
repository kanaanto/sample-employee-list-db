package employee.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employee.model.Login;

@Repository
public class LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean validateUser(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = " from Login where username=:un and password=:pw)";
		Query query = session.createQuery(sql);
		query.setParameter("un", login.getUsername());
		query.setParameter("pw", login.getPassword());
		return query.list().size() > 0;
	}
}
