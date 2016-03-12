package action;

import java.util.Map;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}
	
}
