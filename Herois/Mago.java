package Jogo.Herois;

public class Mago extends Heroi {
	private int mana;

	public Mago(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, int mana) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
}

