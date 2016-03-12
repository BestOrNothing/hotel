package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteMultiRoomAction extends ActionSupport{
	private BaseService baseService;
	private String[] id;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public String[] getId() {
		return id;
	}
	public void setId(String[] id) {
		this.id = id;
	}
	public String execute() throws SQLException{
		String sql = "delete from room where id in (";
		int i;
		sql += "'" + id[0] + "'";
		for(i=1;i<id.length;i++){
			sql += ", '" + id[i] + "'";
		}
		sql += ')';
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
