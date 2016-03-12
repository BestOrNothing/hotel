package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.RoomService;

import com.opensymphony.xwork2.ActionSupport;

public class GoToAddBooking extends ActionSupport{
	private RoomService roomService;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		//System.out.println(id);
		return SUCCESS;
	}
}
