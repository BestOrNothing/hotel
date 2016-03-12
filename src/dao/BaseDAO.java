package dao;

import java.awt.image.RescaleOp;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.BookingInfo;
import model.Room;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.util.finder.Test;

public class BaseDAO extends HibernateDaoSupport{
	@SuppressWarnings("unchecked")
	public List findByHQL(String queryString) throws Exception{
		return  getHibernateTemplate().find(queryString);
	}
	public List findBySQL(String queryString, Class c) throws Exception{
		//test();
		@SuppressWarnings("unchecked")
		List list = getSession().createSQLQuery(queryString).addEntity(c).list();
		return list;
	}
	
	public void updateBySQL(String queryString){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost/hotel";
		    String user = "root";
		    String pw = "root";
		    Connection con = DriverManager.getConnection(dbUrl, user, pw);
		    Statement stm = con.createStatement();
		    stm.executeUpdate(queryString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet findBySQL(String queryString){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost/hotel";
		    String user = "root";
		    String pw = "root";
		    Connection con = DriverManager.getConnection(dbUrl, user, pw);
		    Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery(queryString);
		    return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<BookingInfo> findBookingInfosBySQL(String queryString){
		List list = null;
    		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost/hotel";
		    String user = "root";
		    String pw = "root";
		    Connection con = DriverManager.getConnection(dbUrl, user, pw);
		    Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery(queryString);
		    list = new ArrayList<BookingInfo>();
		    while(rs.next()){
		    		BookingInfo bi = new BookingInfo();
		    		bi.setId(rs.getString("id"));
		    		bi.setInTime(rs.getString("inTime"));
		    		bi.setOutTime(rs.getString("outTime"));
		    		bi.setPrice(rs.getString("price"));
		    		list.add(bi);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		return list;
	}
	void test(){
		String s = "select distinct r.id, r.type, r.price from Room r left join Booking b on r.id=b.id left join User u on u.username=b.username where (b.inTime is null or '2016-02-16'>=b.outTime or '2016-02-18'<=b.inTime) and (r.type='商务大床房')";
		List list = getSession().createSQLQuery(s).list();
		System.out.println(((Room)list.get(0)).getId());
	}
}
