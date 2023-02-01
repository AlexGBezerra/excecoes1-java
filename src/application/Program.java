package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero carro: ");
		int number = sc.nextInt();
		System.out.print("Data do aluguel (dd/MM/yyyy): ");
		Date dataAluguel = sdf.parse(sc.next());
		System.out.print("Data da devolucao (dd/MM/yyyy): ");
		Date dataDevolucao = sdf.parse(sc.next());

		if (!dataDevolucao.after(dataAluguel)) {
			System.out.println("Erro na resarva data devolucao inferior a data do aluguel ");
		} else {
			Reservation reservation = new Reservation(number, dataAluguel, dataDevolucao);
			System.out.println("Reserva: " + reservation);

			System.out.println();
			System.out.println("Entre com uma data para atualizar a reserva ");
			System.out.print("Data do aluguel (dd/MM/yyyy): ");
			dataAluguel = sdf.parse(sc.next());
			System.out.print("Data da devolucao (dd/MM/yyyy): ");
			dataDevolucao = sdf.parse(sc.next());

			
			
			
			String error = reservation.updateDates(dataAluguel, dataDevolucao);
			if (error != null) {
				System.out.println("Error na reserva: " + error);
			} 
			else {
				System.out.println("Reserva: " + reservation);

			}

			sc.close();

		}

	}
}
