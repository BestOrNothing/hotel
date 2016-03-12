package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BookingService;

import com.opensymphony.xwork2.ActionSupport;

public class BookingManageExec extends ActionSupport{
	private String id;
	private BookingService bookingService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BookingService getBookingService() {
		return bookingService;
	}
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		request.setAttribute("list", bookingService.findByProperty("id.id", id));
		return SUCCESS;
	}
}
