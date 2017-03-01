package br.com.sisnoti.modules.user;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.sisnoti.dao.DAO;

/**
 * @author Nicolas Ibanheiz 17 de fev de 2017 - 01:18:17
 */
@Stateless
public class UserDAO extends DAO<User> implements Serializable {
	private static final long serialVersionUID = -4482546606531589184L;

	public UserDAO() {
		super(User.class);
	}
}
