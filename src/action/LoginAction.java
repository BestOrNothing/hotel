package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.BaseService;
import service.UserService;

public class LoginAction extends ActionSupport{
	private UserService userService;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute(){
		boolean flag;
		try {
			User user = userService.findById(username);
			if(user.getPassword().equals(password)) flag = true;
			else flag = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		if(flag){
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);
			return SUCCESS;
		}
		else{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("error", "用户名或密码错误");
			return ERROR;
		}
	}
}
