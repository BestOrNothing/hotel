package action;

import model.User;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport{
	private UserService userService;
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
	public String execute(){
		try {
			User user = userService.findById(username);
			System.out.println(user.getPassword());
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(newPassword);
				userService.updateUser(user);
			}
			else return ERROR;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
