package br.com.sisnoti.exposes;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.sisnoti.modules.user.User;
import br.com.sisnoti.modules.user.UserService;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UserExpose implements Serializable {
	private static final long serialVersionUID = -3447843340982387973L;
	
	@Inject
	private UserService userService;

	@GET
	@Path("/find")
	public List<User> findAll() {
		return userService.findAll();
	}
}
