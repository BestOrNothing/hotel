package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.enterprise.inject.New;

import service.BookingService;

import com.opensymphony.xwork2.ActionSupport;

import dao.CheckInDAO;
import model.Booking;
import model.BookingId;
import model.CheckIn;

public class CheckInAction extends ActionSupport{
	private CheckInDAO checkInDAO;
	private BookingService bookingService;
	public BookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	private String id;
	private String inTime;
	private String outTime;
	private String customer1;
	private String customer2;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CheckInDAO getCheckInDAO() {
		return checkInDAO;
	}

	public void setCheckInDAO(CheckInDAO checkInDAO) {
		this.checkInDAO = checkInDAO;
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

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getCustomer1() {
		return customer1;
	}

	public void setCustomer1(String customer1) {
		this.customer1 = customer1;
	}

	public String getCustomer2() {
		return customer2;
	}

	public void setCustomer2(String customer2) {
		this.customer2 = customer2;
	}
	
	public String execute() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(customer1);
		checkInDAO.save(new CheckIn(id, sdf.parse(inTime), sdf.parse(outTime), customer1, customer2));
		Booking booking;
		if(username != null && !username.equals("")) {
			booking = (Booking) bookingService.findById(new BookingId(username, id, sdf.parse(inTime)));
			bookingService.deleteBooking(booking);
		}
		return SUCCESS;
	}
	
}
