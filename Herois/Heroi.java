package Jogo.Herois;


import Jogo.Monstros.Monstro;
import Jogo.Personagem;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

public abstract class Heroi extends Personagem {
	protected TipoHeroi classe;
	protected TipoArma armaPrincipal;
	private boolean paralisado = false;

	public Heroi(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoHeroi classe, TipoArma armaPrincipal) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.classe = classe;
		this.armaPrincipal = armaPrincipal;
    }

	protected abstract void realizarAcao(Monstro monstro);

	public abstract void sofrerDano(int dano);

}
