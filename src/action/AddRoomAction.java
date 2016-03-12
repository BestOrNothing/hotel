package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BaseService;
import service.RoomService;
import model.Room;

import com.opensymphony.xwork2.ActionSupport;

public class AddRoomAction extends ActionSupport{
	private RoomService roomService;
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private String id;
	private String type;
	private String price;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	public String execute() throws SQLException{
		Room room = new Room(id, type, Integer.parseInt(price));
		roomService.save(room);
		String sql = "select r.id, r.type, r.price, c.customer1, c.customer2 "
				+ "from room r left join checkin c on r.id=c.id ";
		List list2 = baseService.findBySQL(sql, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", list2);
		return SUCCESS;
	}
}
