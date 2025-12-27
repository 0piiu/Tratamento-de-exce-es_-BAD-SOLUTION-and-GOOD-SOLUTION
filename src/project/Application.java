package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;


public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reservation reservation = new Reservation();
		Scanner leitor = new Scanner(System.in);
		
			System.out.print("Room number " );
			int roomNumber = leitor.nextInt();
			 	
			System.out.print("check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(leitor.next(),format); 
			
			System.out.print("check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(leitor.next(),format); 
			  
			  
				if(!checkOut.isAfter(checkIn)) { // verificação dentro do programa principal, tratamento de exceção muito ruim
					System.out.println("Error in reservation: check-out date must be after check-in date");
				} 
				else {
					reservation = new Reservation(roomNumber, checkIn, checkOut);
					System.out.println("Reservation:" + reservation);
					
				}
				
				System.out.println();
				
				System.out.println("Enter data to update the reservation: ");
								 	
					System.out.print("check-in date (dd/MM/yyyy): ");
					checkIn = LocalDate.parse(leitor.next(),format); 
					
					System.out.print("check-out date (dd/MM/yyyy): ");
					checkOut = LocalDate.parse(leitor.next(),format); 
					
					String error  = reservation.updateDates(checkIn, checkOut); // metodo "reservation.updateDates", me retorna String
						if (error != null) {
							System.out.println("Error in reservation: " + error);
						}
						else {
							System.out.println("Reservation " + reservation );
						}
					
		leitor.close();
	}
}
