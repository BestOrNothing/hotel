package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Room;

import org.apache.struts2.ServletActionContext;

import service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	private String inTime;
	private String outTime;
	private String[] type;
	private String res;
	private BaseService baseService;
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
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
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public String execute(){
		int len = type.length;
		String s = "select r.id, r.type, r.price " 
				+ "from Room r left join Booking b on r.id=b.id left join CheckIn c on r.id=c.id "
				+ "where not exists ( "
				+ "select * "
				+ "from Room r1 left join Booking b1 on r1.id=b1.id left join CheckIn c1 on r1.id=c1.id "
				+ "where r.id=r1.id "
				+ "and ((b1.inTime is not null and '" + inTime + "'<b1.outTime and '" + outTime + "'>b1.inTime) " 
				+ "or (c1.inTime is not null and '" + inTime + "'<c1.outTime and '" + outTime + "'>c1.inTime)) " 
				+ ") ";
		if(len > 0) s += "and (r.type='" + type[0] + "'";
		for(int i=1;i<len;i++){
			s += " or r.type='" + type[i] + "'";
		}
		if(len > 0) s += ")";
		System.out.println(s);
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Room> list;
		try {
			System.out.println(s);
			list = baseService.findBySQL(s, Room.class);
			request.setAttribute("list", list);
			request.setAttribute("inTime", inTime);
			request.setAttribute("outTime", outTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR + res;
		}
		return res;
	}
}
