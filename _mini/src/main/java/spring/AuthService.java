package spring;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

@Setter
public class AuthService {

	@Autowired
	private UserDao userDao;
	
	// id가 null이거나 비밀번호가 맞지 않으면 에러처리, 아니면 id, 이름 저장
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
