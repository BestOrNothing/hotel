package service;

import java.util.List;

import model.Room;
import dao.RoomDAO;

public class RoomService {
	private RoomDAO roomDAO;

	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	public void delete(Room room){
		roomDAO.delete(room);
	}
	
	public void save(Room room){
		roomDAO.save(room);
	}
	
	public List findAll() {
		return roomDAO.findAll();
	}
}
