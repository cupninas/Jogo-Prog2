package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;
import java.util.Random;

public class Mago extends Heroi {

	private boolean manaReservada = false;

	// Construtor principal com todos os atributos
	public Mago(String nome, int vida, int defesa, int destreza, int velocidade) {
		super(nome, vida, defesa, destreza, velocidade, TipoHeroi.MAGO);

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

	}

	@Override
	public void comecarNovoTurno() { desativarManaReservada(); }

	private void rajadaArcana(Monstro monstro) {
		System.out.println(getNome() + " lança uma RAJADA ARCANA!");
		int dano = this.getAtaque();
		if (manaReservada) {
			dano += 15; // Se tiver mana reservada, o dano aumenta
			desativarManaReservada();
		}
		monstro.sofrerDano(dano);
	}

	private void explosaoElemental(Monstro monstro) {
		System.out.println(getNome() + " conjura uma EXPLOSÃO ELEMENTAL!");
		int dano = this.getAtaque() * (manaReservada ? 2 : 1);
		monstro.sofrerDano(dano);
		desativarManaReservada();
	}

	private void raioDesintegrador(Monstro monstro) {
		System.out.println(getNome() + " dispara um RAIO DESINTEGRADOR!");
		int dano = this.getAtaque();
		if (manaReservada) {
			dano *= 2;
			desativarManaReservada();
		}
		monstro.sofrerDano(dano);
	}

	private void setasMisticas(Monstro monstro) {
		System.out.println(getNome() + " lança múltiplas SETAS MÍSTICAS!");
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
		System.out.println(getNome() + " começou a acumular energia mágica!");
	}

	public void desativarManaReservada() {
		this.manaReservada = false;
		System.out.println(getNome() + " dispersou sua energia mágica acumulada.");
	}
}

