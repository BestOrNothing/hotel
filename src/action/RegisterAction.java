package action;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.BaseService;
import service.UserService;

public class RegisterAction extends ActionSupport{
	private BaseService baseService;
	private UserService userService;
	private String username;
	private String password;
	private String mail;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BaseService getBaseService() {
		return baseService;
	}
	
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	} 
	
	public String execute(){
		User user = new User(username, password, mail);
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "注册失败，用户名、密码或邮箱不合法。");
			return ERROR;
		}
		Map session = ActionContext.getContext().getSession();
		session.put("username", username);
		return SUCCESS;
	}
	
}
