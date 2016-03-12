package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.Booking;
import model.BookingId;
import service.BookingService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteBookingAction extends ActionSupport{
	private BookingService bookingService;
	private String id;
	private String inTime;
	private String username;
	private String outTime;
	public BookingService getBookingService() {
		return bookingService;
	}
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String execute() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Booking booking = new Booking(new BookingId(username, id, sdf.parse(inTime)), sdf.parse(outTime));
		bookingService.deleteBooking(booking);
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println();
		request.setAttribute("list", bookingService.findByProperty("id.id", id));
		return SUCCESS;
	}
}
