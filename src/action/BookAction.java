package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.Booking;
import model.BookingId;
import service.BookingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private BookingService bookingService;
	private String id;
	private String username;
	private String inTime;
	private String outTime;
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public BookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	public String execute() throws ParseException{
		Map session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		if(session.get("username") == null){
			request.setAttribute("error", "订房请您先登录");
			return "toLogin";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Booking booking = new Booking(new BookingId(username, id, sdf.parse(inTime)), sdf.parse(outTime));
		try {
			bookingService.saveBooking(booking);
			request.setAttribute("inTime", inTime);
			request.setAttribute("outTime", outTime);
			request.setAttribute("username", username);
			request.setAttribute("id", id);
			request.setAttribute("price", price);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
