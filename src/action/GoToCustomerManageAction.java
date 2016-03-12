package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class GoToCustomerManageAction extends ActionSupport{
	private BaseService baseService;

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public String execute() throws SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = baseService.findBySQL(
				"select customer1 as customer, id, inTime, outTime "
				+ "from CheckIn c "
				+ "where c.customer1 is not null and c.customer1!='' "
				+ "union " 
				+ "select customer2 as customer, id, inTime, outTime "
				+ "from CheckIn c "
				+ "where c.customer2 is not null and c.customer2!='' "
				, 4);
		request.setAttribute("list", list);
		return SUCCESS;
	}
}
