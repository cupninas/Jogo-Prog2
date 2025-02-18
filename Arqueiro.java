package Jogo;

public class Arqueiro extends Classe {
	private int taxaPrecisao;
	
	public Arqueiro(String nome, String arma, String tipoDano, String habilidade, int taxaPrecisao) {
		super(nome, arma, tipoDano, habilidade);
		this.taxaPrecisao = taxaPrecisao;
	}

	public int getTaxaPrecisao() {
		return taxaPrecisao;
	}

	public void setTaxaPrecisao(int taxaPrecisao) {
		this.taxaPrecisao = taxaPrecisao;
	}
	
}
