package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

public class Arqueiro extends Heroi {

	private boolean flechaCarregada = false; // Estado para ataques carregados

	public Arqueiro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoArma armaPrincipal) {
		// TODO - irei fazer uns gets armas especificas para cada heroi aqui
		super(nome, vida, ataque, defesa, destreza, velocidade, TipoHeroi.ARQUEIRO, armaPrincipal);
	}

	public Arqueiro() {
		// TODO - irei fazer uns gets armas especificas para cada heroi aqui
		super("Arqueiro", 200, 25, 10, 15, 7, TipoHeroi.ARQUEIRO, TipoArma.ESPADA_CURTA);
	}

	@Override
	protected void realizarAcao(Monstro monstro) {
		//a flecha carregada tem influencia aqui, quando esta ativada tem mais chance da acao acontecer
	}

	@Override
	public void sofrerDano(int dano) {
	}

	private void disparoComFlecha(Monstro monstro) {
		System.out.println(this.getNome() + " dispara uma flecha com sua " + armaPrincipal.getNome() + "!");

		int danoBase = this.getAtaque() + 5;
		if (flechaCarregada) {
			danoBase *= 1.5;
			System.out.println("Flecha carregada! O ataque é mais forte!");
			flechaCarregada = false;
		}

		if (Math.random() < 0.25) {
			danoBase *= 2;
			System.out.println("GOLPE CRÍTICO! A flecha perfura a armadura do inimigo!");
		}

		int danoFinal = danoBase - monstro.getDefesa();
		if (danoFinal < 0) danoFinal = 0;

		monstro.sofrerDano(danoFinal);
		System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
	}

	private void ataqueRapido(Monstro monstro) {
		System.out.println(this.getNome() + " desfere ataques rápidos com sua " + armaPrincipal.getNome() + "!");

		int danoBase = this.getAtaque();
		if (armaPrincipal == TipoArma.ADAGA) {
			danoBase -= 5;
			System.out.println("Ataques mais rápidos, mas com menos dano!");
		}

		if (Math.random() < 0.2) {
			System.out.println("Ataque duplo! O Arqueiro desfere um golpe extra!");
			danoBase *= 2;
		}

		int danoFinal = danoBase - monstro.getDefesa();
		if (danoFinal < 0) danoFinal = 0;

		monstro.sofrerDano(danoFinal);
		System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
	}

	public void carregarFlecha() {
		System.out.println(this.getNome() + " prepara uma flecha carregada para o próximo turno!");
		flechaCarregada = true;
	}
}
