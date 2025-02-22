package Jogo.Herois;

public class Ladino extends Heroi {
	private int taxaEsquiva;

	public Ladino(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, int taxaEsquiva) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.taxaEsquiva = taxaEsquiva;
	}

	public int getTaxaEsquiva() {
		return taxaEsquiva;
	}

	public void setTaxaEsquiva(int taxaEsquiva) {
		this.taxaEsquiva = taxaEsquiva;
	}
}
