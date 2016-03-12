package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Room;

import org.hibernate.Session;

import dao.BaseDAO;

public class BaseService {
	private BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	public List<Room> findByHQL(String queryString) throws Exception{
		return baseDAO.findByHQL(queryString);
	}
	
	public List findBySQL(String queryString, Class c) throws Exception{
		return baseDAO.findBySQL(queryString, c);
	}
	
	public List findBookingInfosBySQL(String queryString){
		return baseDAO.findBookingInfosBySQL(queryString);
	}
	/*
	 * 
	 */
	public List<String[]> findBySQL(String queryString, int cnt) throws SQLException{
		List<String[]> list = new ArrayList<String[]>(); 
		ResultSet rs = baseDAO.findBySQL(queryString);
		while(rs.next()){
			String[] strings = new String[cnt];
			for(int i=0; i<cnt; i++){
				strings[i] = rs.getString(i+1);
			}
			list.add(strings);
		}
		return list;
	}
	
	public void updateBySQL(String sql){
		baseDAO.updateBySQL(sql);
	}
}
