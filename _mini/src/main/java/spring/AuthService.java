package spring;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

@Setter
public class AuthService {

	@Autowired
	private UserDao userDao;
	
	public AuthInfo authenticate(Integer id, String password) {
		User user = userDao.selectId(id);
		if (user == null) {
			throw new WrongIdPasswordException();
		}
		if (!user.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(user.getId(), user.getName());
	}
}
