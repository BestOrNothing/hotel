package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.annotations.Where;

import service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class GoToRoomManageAction extends ActionSupport{
	private BaseService baseService;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public String execute() throws SQLException{
		String sql = "select r.id, r.type, r.price, c.customer1, c.customer2 "
				+ "from room r left join checkin c on r.id=c.id "
				+ "order by r.id asc";
		if(id != null && !id.equals("")) sql += "where r.id='" + id + "'";
		List list = baseService.findBySQL(sql, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
}
