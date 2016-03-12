package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.User;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class InquireMyInfoAction extends ActionSupport{
	private UserService userService;
	private String username;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String execute() throws Exception{
		User user = userService.findById(username);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		return SUCCESS;
	}
}
