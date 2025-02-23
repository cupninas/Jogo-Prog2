package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ladino extends Heroi {
	private int taxaEsquiva = 4;

	public Ladino(String nome, int vida, int defesa, int destreza, int velocidade, int taxaEsquiva) {
		super(nome, vida, defesa, destreza, velocidade, TipoHeroi.LADINO);

		List<TipoArma> armasGuerreiro = TipoArma.obterArmasParaGuerreiro();
		TipoArma armaGuerreiro = armasGuerreiro.get(RANDOM.nextInt(armasGuerreiro.size()));

		this.ataque = TipoHeroi.LADINO.getAtaque()+armaGuerreiro.getAtaque();
		this.armaPrincipal = armaGuerreiro;
	}

	public Ladino() {
		super("Guerreiro", 300, 20, 8, 4, TipoHeroi.LADINO);

		List<TipoArma> armasGuerreiro = TipoArma.obterArmasParaGuerreiro();
		TipoArma armaGuerreiro = armasGuerreiro.get(RANDOM.nextInt(armasGuerreiro.size()));

		this.ataque = TipoHeroi.LADINO.getAtaque()+armaGuerreiro.getAtaque();
		this.armaPrincipal = armaGuerreiro;
	}

	@Override
	protected void realizarAcao(Monstro monstro) throws Exception {

	}

	@Override
	public void sofrerDano(int dano) {

	}

	@Override
	public void comecarNovoTurno() {

	}
}