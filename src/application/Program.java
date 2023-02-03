package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero carro: ");
			int number = sc.nextInt();
			System.out.print("Data do aluguel (dd/MM/yyyy): ");
			Date dataAluguel = sdf.parse(sc.next());
			System.out.print("Data da devolucao (dd/MM/yyyy): ");
			Date dataDevolucao = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, dataAluguel, dataDevolucao);
			System.out.println("Reserva: " + reservation);
	
			System.out.println();
			System.out.println("Entre com uma data para atualizar a reserva ");
			System.out.print("Data do aluguel (dd/MM/yyyy): ");
			dataAluguel = sdf.parse(sc.next());
			System.out.print("Data da devolucao (dd/MM/yyyy): ");
			dataDevolucao = sdf.parse(sc.next());
	
			reservation.updateDates(dataAluguel, dataDevolucao);
	
			System.out.println("Reserva: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Formadto de data invalido");
		}
		catch(DomainException e) {
				System.out.println("Error na Reserva: " + e.getMessage());
			}
		catch (RuntimeException e) {
			System.out.println(" Erro inesperado");
		}
		
		
		sc.close();

	}

}
