package action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CheckInDAO;
import model.CheckIn;

public class CheckOutAction extends ActionSupport{
	private CheckInDAO checkInDAO;
	private String id;

	public CheckInDAO getCheckInDAO() {
		return checkInDAO;
	}

	public void setCheckInDAO(CheckInDAO checkInDAO) {
		this.checkInDAO = checkInDAO;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			CheckIn checkIn = checkInDAO.findById(id);
			checkInDAO.delete(checkIn);
			request.setAttribute("p", "退房成功");
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("p", "退房失败");
			return SUCCESS;
		}
	}
}
