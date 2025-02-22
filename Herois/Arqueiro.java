package Jogo.Herois;

public class Arqueiro extends Heroi {
	private int taxaPrecisao;

	public Arqueiro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, int taxaPrecisao) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.taxaPrecisao = taxaPrecisao;
	}

	public Arqueiro() {
		super("Arqueiro", 150, 20, 10, 10, 5);
		this.taxaPrecisao = 30;
	}

	public int getTaxaPrecisao() {
		return taxaPrecisao;
	}

	public void setTaxaPrecisao(int taxaPrecisao) {
		this.taxaPrecisao = taxaPrecisao;
	}
	
}
