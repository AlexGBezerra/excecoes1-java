package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer numeroCarro;
	private Date dataAluguel;
	private Date dataDevolucao;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reservation(Integer numeroCarro, Date dataAluguel, Date dataDevolucao) {
		
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
