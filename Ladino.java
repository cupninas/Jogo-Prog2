package Jogo;

public class Ladino extends Classe {
	private int taxaEsquiva;
	
	public Ladino(String nome, String arma, String tipoDano, String habilidade, int taxaEsquiva) {
		super(nome, arma, tipoDano, habilidade);
		this.taxaEsquiva = taxaEsquiva;
	}

	public int getTaxaEsquiva() {
		return taxaEsquiva;
	}

	public void setTaxaEsquiva(int taxaEsquiva) {
		this.taxaEsquiva = taxaEsquiva;
	}
}
