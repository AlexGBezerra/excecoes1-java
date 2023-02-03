package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer numeroCarro;
	private Date dataAluguel;
	private Date dataDevolucao;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reservation(Integer numeroCarro, Date dataAluguel, Date dataDevolucao)  {
		
		if (!dataDevolucao.after(dataAluguel)) {
			throw new DomainException ("Erro na reserva data devolucao inferior a data do aluguel ");
		}
		
		this.numeroCarro = numeroCarro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}
	public Integer getNumeroCarro() {
		return numeroCarro;
	}
	public void setNumeroCarro(Integer numeroCarro) {
		this.numeroCarro = numeroCarro;
	}
	public Date getDataAluguel() {
		return dataAluguel;
	}
	
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	public long duracao() {
		long diferenca = dataDevolucao.getTime() - dataAluguel.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date dataAluguel, Date dataDevolucao) {
		Date now = new Date();
		if (dataAluguel.before(now) || dataDevolucao.before(now)) {
			throw new DomainException( "Erro na reserva: Datas para atualizacao precisao ser futuras");

		} 
		if (!dataDevolucao.after(dataAluguel)) {
			throw new DomainException ("Erro na reserva data devolucao inferior a data do aluguel ");
		}
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		
	}
	
	@Override
	public String toString() {
		return "Numero "
			   + numeroCarro
			   + ", dataAluguel: "
			   + sdf.format(dataAluguel)
			   + ", dataDevolucao: "
			   + sdf.format(dataAluguel)
			   +", "
			   + duracao()
			   + " noites";
	}
	
	
	

}
