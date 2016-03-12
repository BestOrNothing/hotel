package service;

import java.util.List;

import model.Booking;
import model.BookingId;
import dao.BookingDAO;

public class BookingService {
	private BookingDAO bookingDAO;

	public BookingDAO getBookingDAO() {
		return bookingDAO;
	}

	public void setBookingDAO(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}
	
	public void saveBooking(Booking booking) throws Exception{
		bookingDAO.save(booking);
	}
	
	public void deleteBooking(Booking booking) throws Exception{
		bookingDAO.delete(booking);
	}
	
	public List findByProperty(String propertyName, Object value){
		return bookingDAO.findByProperty(propertyName, value);
	}
	
	public List findAll(){
		return bookingDAO.findAll();
	}
	
	public Booking findById(BookingId id){
		return bookingDAO.findById(id);
	}
	
}
