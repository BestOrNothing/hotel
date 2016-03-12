package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BaseService;
import service.RoomService;
import model.Room;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteRoomAction extends ActionSupport{
	private RoomService roomService;
	private String[] strings;
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public String[] getStrings() {
		return strings;
	}
	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	
	public String execute() throws SQLException{
		System.out.println(strings[0] + strings[1] + strings[2]);
		roomService.delete(new Room(strings[0], strings[1], Integer.parseInt(strings[2])));
		//System.out.println(2);
		String sql = "select r.id, r.type, r.price, c.customer1, c.customer2 "
				+ "from room r left join checkin c on r.id=c.id ";
		List list1 = baseService.findBySQL(sql, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list1", list1);
		return SUCCESS;
	}
	
}
