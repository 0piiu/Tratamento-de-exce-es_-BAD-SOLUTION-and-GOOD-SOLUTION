package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
 
	public long duration() {
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		
		LocalDate now =  LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) { // verifiação, no metododo responsavel, DELEGAÇÃO ---> cria logica para que a reserva so possa ser criada em datas futuras em relaçao a agora (now)
			return "Error in reservation: Reservation dates for updates must be futures dates ";
		}
		if (!checkOut.isAfter(checkIn)) { // verifiação, no metododo responsavel, DELEGAÇÃO
				return"Error in reservation: check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; // caso, nao entre em nenhum dos if's, retorna nulo
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber 
				+ ", check-in " 
				+ format.format(checkIn) 
				+ ", check-out " 
				+ format.format(checkOut) 
				+ ", " 
				+ duration() 
				+ " nights";
	}
	
}
