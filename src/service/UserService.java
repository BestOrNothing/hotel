package service;

import model.User;
import dao.UserDAO;

public class UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void saveUser(User user) throws Exception{
		userDAO.save(user);
	}
	
	public User findById(String id) throws Exception{
		return userDAO.findById(id);
	}
	
	public void updateUser(User user){
		userDAO.update(user);
	}
}
