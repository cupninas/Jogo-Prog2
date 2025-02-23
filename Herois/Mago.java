package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;

public class Mago extends Heroi {

	private int manaReservada = 0;

	// Construtor principal com todos os atributos
	public Mago(String nome, int vida, int defesa, int destreza, int velocidade) {
		super(nome, vida, defesa, destreza, velocidade, TipoHeroi.MAGO);

		List<TipoArma> armasMago = TipoArma.obterArmasParaMago();
		this.armaPrincipal = armasMago.get(RANDOM.nextInt(armasMago.size()));
		this.ataque = TipoHeroi.MAGO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	public Mago() {
		super("Mago", 500, 30, 50, 20, TipoHeroi.MAGO);

		List<TipoArma> armasMago = TipoArma.obterArmasParaMago();
		this.armaPrincipal = armasMago.get(RANDOM.nextInt(armasMago.size()));
		this.ataque = TipoHeroi.MAGO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	@Override
	public void realizarAcao(Monstro monstro) throws Exception {

	}

	@Override
	public void sofrerDano(int dano) {

	}

	@Override
	public void comecarNovoTurno() {

	}
}

