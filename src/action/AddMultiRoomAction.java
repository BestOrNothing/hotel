package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class AddMultiRoomAction extends ActionSupport{
	private BaseService baseService;
	private String[] id;
	private String[] price;
	private String[] type;

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public String execute() throws SQLException{
		int len = id.length;
		int i;
		String sql = "insert into room(id, price, type) ";
		sql += "values('" + id[0] + "', '" + price[0] + "', '" + type[0] + "')";
		for(i=1;i<len;i++){
			sql += ",('" + id[i] + "', '" + price[i] + "', '" + type[i] + "')";
		}
		baseService.updateBySQL(sql);
		sql = "select r.id, r.type, r.price, c.customer1, c.customer2 "
				+ "from room r left join checkin c on r.id=c.id "
				+ "order by r.id asc";
		List list = baseService.findBySQL(sql, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
}
