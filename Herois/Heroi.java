package Jogo.Herois;
import Jogo.Monstros.Monstro;
import Jogo.Personagem;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;

public abstract class Heroi extends Personagem {
	protected TipoHeroi classe;
	protected TipoArma armaPrincipal;

	public Heroi(String nome, int vida, int defesa, int destreza, int velocidade, TipoHeroi classe) {
		super(nome, vida, 0, defesa, destreza, velocidade);
		this.classe = classe;
    }

	public abstract void realizarAcao(Monstro monstro) throws Exception;

}