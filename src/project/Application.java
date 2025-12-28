package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;


public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reservation reservation = new Reservation();
		Scanner leitor = new Scanner(System.in);
			
			try {
				System.out.print("Room number " );
				int roomNumber = leitor.nextInt();
				 	
				System.out.print("check-in date (dd/MM/yyyy): ");
				LocalDate checkIn = LocalDate.parse(leitor.next(),format); 
				
				System.out.print("check-out date (dd/MM/yyyy): ");
				LocalDate checkOut = LocalDate.parse(leitor.next(),format); 
				
					reservation = new Reservation(roomNumber, checkIn, checkOut);
					System.out.println("Reservation:" + reservation);		
					
					System.out.println();
					
					System.out.println("Enter data to update the reservation: ");
									 	
					System.out.print("check-in date (dd/MM/yyyy): ");
						checkIn = LocalDate.parse(leitor.next(),format); 
						
					System.out.print("check-out date (dd/MM/yyyy): ");
						checkOut = LocalDate.parse(leitor.next(),format); 
						
					reservation.updateDates(checkIn, checkOut); // metodo "reservation.updateDates", me retorna String
						System.out.println("Reservation " + reservation );
			}
			catch(IllegalArgumentException erro){
				System.out.println("Error in reservation " + erro.getMessage());
			}
			catch (DomainExceptions exception) {
				System.out.println("Error in reservation " + exception.getMessage());
			}
			catch(RuntimeException exception) { // tipo de exceção generio
				System.out.println("Unexpected Error!");
			}
					
		leitor.close();
	}
}
