package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.Booking;
import service.BaseService;
import service.BookingService;

import com.opensymphony.xwork2.ActionSupport;

public class ListBookingWhenCheckInAction extends ActionSupport{
	private BookingService bookingService;
	private BaseService baseService;
	private String username;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public BookingService getBookingService() {
		return bookingService;
	}
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * <th>预定用户</th>
			<th>房号</th>
			<th>房间类型</th>
			<th>价格</th>
			<th>入店时间</th>
			<th>离店时间</th>
	 * 
	 */
	public String execute() throws SQLException{
		List<String[]> list;
		if(username == null || username.equals("")){
			list = baseService.findBySQL("select b.username, r.id, r.type, r.price, b.inTime, b.outTime "
					+ "from Room r inner join Booking b on r.id=b.id ", 6);
		}
		else{
			list = baseService.findBySQL("select b.username, r.id, r.type, r.price, b.inTime, b.outTime "
					+ "from Room r inner join Booking b on r.id=b.id "
					+ "where b.username='" + username + "'", 6);
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
}
