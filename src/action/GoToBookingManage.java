package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Room;
import service.BaseService;
import service.RoomService;

public class GoToBookingManage extends ActionSupport{
	private BaseService baseService;
	private RoomService roomService;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", roomService.findAll());
		return SUCCESS;
	}
}
