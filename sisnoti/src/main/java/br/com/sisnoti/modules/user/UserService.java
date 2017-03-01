package br.com.sisnoti.modules.user;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Nicolas Ibanheiz 17 de fev de 2017 - 01:16:40
 */
public class UserService implements Serializable {
	private static final long serialVersionUID = -9106814321461023232L;

	@Inject
	private UserDAO userDAO;

	/**
	 * @author Nicolas Ibanheiz 17 de fev de 2017 - 01:22:58
	 * @return List of users
	 */
	public List<User> findAll() {
		return userDAO.findAll();
	}
}
