package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GoToCheckInAction extends ActionSupport{
	private String[] strings;
	private String id;
	private String type;
	private String price;
	private String inTime;
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

	private String outTime;

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(strings != null){
			request.setAttribute("username", strings[0]);
			request.setAttribute("id", strings[1]);
			request.setAttribute("type", strings[2]);
			request.setAttribute("price", strings[3]);
			request.setAttribute("inTime", strings[4]);
			request.setAttribute("outTime", strings[5]);
		}
		else{
			request.setAttribute("id", id);
			request.setAttribute("type", type);
			request.setAttribute("price", price);
			request.setAttribute("inTime", inTime);
			request.setAttribute("outTime", outTime);
		}
		return SUCCESS;
	}
}
