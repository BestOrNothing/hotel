package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.BookingInfo;
import model.Room;
import service.BaseService;
import service.BookingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryMyBookingInfoAction extends ActionSupport{
	private BookingService bookingService;
	private BaseService baseService;
	private String inTime;
	private String outTime;
	private String queryType;

	public String execute() throws Exception{
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		List<BookingInfo> list;
		if(queryType.equals("查询我的所有住房情况")){
			list = baseService.findBookingInfosBySQL("select r.id, b.inTime, b.outTime, r.price "
					+ "from booking b inner join room r on b.id=r.id "
					+ "where b.username='" + username +  "' ");
		}
		else if(queryType.equals("按入店时间查询")){
			list = baseService.findBookingInfosBySQL("select r.id, b.inTime, b.outTime, r.price "
					+ "from Booking b inner join Room r on b.id=r.id "
					+ "where b.username='" + username + "' "
					+ "and b.inTime='" + inTime + "' ");
		}
		else{
			list = baseService.findBookingInfosBySQL("select r.id, b.inTime, b.outTime, r.price "
					+ "from Booking b inner join Room r on b.id=r.id "
					+ "where b.username='" + username + "' "
					+ "and b.outTime='" + outTime + "' ");
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		request.setAttribute("thisDay", sdf.format(new Date()));
		return SUCCESS;		
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
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

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public BookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	
}
