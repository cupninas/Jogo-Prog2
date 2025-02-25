package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;
import java.util.Random;

import static Jogo.Jogo.log;

public class Mago extends Heroi {
	// Construtor principal com todos os atributos
	public Mago(int vida, int defesa, int destreza, int velocidade) {
		super("Mago", vida, defesa, destreza, velocidade, TipoHeroi.MAGO);

		List<TipoArma> armasMago = TipoArma.obterArmasParaMago();
		this.armaPrincipal = armasMago.get(RANDOM.nextInt(armasMago.size()));
		this.ataque = TipoHeroi.MAGO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	// Construtor com valores padrão de um Mago típico
	public Mago() {
		super("Mago", 500, 30, 50, 20, TipoHeroi.MAGO);

		List<TipoArma> armasMago = TipoArma.obterArmasParaMago();
		this.armaPrincipal = armasMago.get(RANDOM.nextInt(armasMago.size()));
		this.ataque = TipoHeroi.MAGO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	//--------------------- Atributos escudos --------------------

	private boolean manaReservada = false;

	//--------------------- Factories --------------------

	@Override
	public void realizarAcao(Monstro monstro) throws Exception {
		//TODO - realizar algum dos ataques de forma randomica
		Random random = new Random();
		int escolha = random.nextInt(5);
		switch (escolha) {
			case 0 -> ativarManaReservada();
			case 1 -> rajadaArcana(monstro);
			case 2 -> explosaoElemental(monstro);
			case 3 -> raioDesintegrador(monstro);
			case 4 -> setasMisticas(monstro);
			default -> throw new Exception();
		};
	}

	@Override
	public void sofrerDano(int dano) {
		if (manaReservada) {
			log.addLog(this.getNome() + " utilizou mana reservada para anular o dano!");
			desativarManaReservada();
		} else {
			this.vida -= dano;
			log.addLog(this.getNome() + " sofreu " + dano + " de dano!");
		}
	}

	//--------------------- Ações de ataque --------------------

	private void rajadaArcana(Monstro monstro) {
		log.addLog(getNome() + " lança uma RAJADA ARCANA!");
		int dano = this.getAtaque();
		if (manaReservada) {
			dano += 15; // Se tiver mana reservada, o dano aumenta
			desativarManaReservada();
		}
		monstro.sofrerDano(dano);
	}

	private void explosaoElemental(Monstro monstro) {
		log.addLog(getNome() + " conjura uma EXPLOSÃO ELEMENTAL!");
		int dano = this.getAtaque() * (manaReservada ? 2 : 1);
		monstro.sofrerDano(dano);
		desativarManaReservada();
	}

	private void raioDesintegrador(Monstro monstro) {
		log.addLog(getNome() + " dispara um RAIO DESINTEGRADOR!");
		int dano = this.getAtaque();
		if (manaReservada) {
			dano *= 2;
			desativarManaReservada();
		}
		monstro.sofrerDano(dano);
	}

	private void setasMisticas(Monstro monstro) {
		log.addLog(getNome() + " lança múltiplas SETAS MÍSTICAS!");
		int dano = this.getAtaque() / 2;
		if (manaReservada) {
			dano *= 2;
			desativarManaReservada();
		}
		for (int i = 0; i < 3; i++) {
			monstro.sofrerDano(dano);
		}
	}

	//--------------------- Métodos de Manipulação de Mana --------------------

	public void ativarManaReservada() {
		this.manaReservada = true;
		log.addLog(getNome() + " começou a acumular energia mágica!");
	}

	public void desativarManaReservada() {
		this.manaReservada = false;
		log.addLog(getNome() + " dispersou sua energia mágica acumulada.");
	}
}

