package Jogo.Herois;


import Jogo.Personagem;

public class Heroi extends Personagem {
	public Heroi(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
	}

	@Override
	protected void realizarAtaque() {}
}
