package Jogo;

public class Mago extends Classe {
	private int mana;
	
	public Mago(String nome, String arma, String tipoDano, String habilidade, int mana) {
		super(nome, arma, tipoDano, habilidade);
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
}

