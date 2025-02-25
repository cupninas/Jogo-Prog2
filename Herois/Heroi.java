package Jogo.Herois;


import Jogo.Log;
import Jogo.Monstros.Monstro;
import Jogo.Personagem;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;
import lombok.Setter;

public abstract class Heroi extends Personagem {
	protected TipoHeroi classe;
	protected TipoArma armaPrincipal;
	@Setter
    private boolean paralisado = false;

	public Heroi(String nome, int vida, int defesa, int destreza, int velocidade, TipoHeroi classe) {
		super(nome, vida, 0, defesa, destreza, velocidade);
		this.classe = classe;
    }

	public abstract void realizarAcao(Monstro monstro) throws Exception;

}