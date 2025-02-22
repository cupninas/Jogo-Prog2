package Jogo.Herois;


import Jogo.Monstros.Monstro;
import Jogo.Personagem;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

public abstract class Heroi extends Personagem {
	private TipoArma armaPrincipal;
	private TipoHeroi classe;

	public Heroi(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoArma armaPrincipal, TipoHeroi classe) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
        this.armaPrincipal = armaPrincipal;
		this.classe = classe;
    }

	protected abstract void realizarAtaque(Monstro monstro);


}
