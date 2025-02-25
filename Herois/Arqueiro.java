package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;
import java.util.Random;

import static Jogo.Jogo.log;

public class Arqueiro extends Heroi {

	// Construtor principal com todos os atributos
	public Arqueiro(int vida, int defesa, int destreza, int velocidade) {
		super("Arqueiro", vida, defesa, destreza, velocidade, TipoHeroi.ARQUEIRO);

		List<TipoArma> armasArqueiro = TipoArma.obterArmasParaArqueiro();
		this.armaPrincipal = armasArqueiro.get(RANDOM.nextInt(armasArqueiro.size()));
		this.ataque = TipoHeroi.ARQUEIRO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	// Construtor com valores padrão de um Arqueiro típico
	public Arqueiro() {
		super("Arqueiro", 200, 25, 10, 15, TipoHeroi.ARQUEIRO);

		List<TipoArma> armasArqueiro = TipoArma.obterArmasParaGuerreiro();
		this.armaPrincipal = armasArqueiro.get(RANDOM.nextInt(armasArqueiro.size()));
		this.ataque = TipoHeroi.ARQUEIRO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	//--------------------- Atributos escudos --------------------

	private boolean flechaCarregada = false; // Estado para ataques carregados

	//--------------------- Factories --------------------

	@Override
	public void realizarAcao(Monstro monstro) throws Exception {
		//TODO - a flecha carregada tem influencia aqui, quando esta ativada tem mais chance da acao acontecer. realizar algum dos ataques de forma randomica
		Random random = new Random();
		int escolha = random.nextInt(4);
		switch (escolha) {
			case 0 -> disparoComFlecha(monstro);
			case 1 -> ataqueRapido(monstro);
			case 2 -> carregarFlecha();
			default -> throw new Exception();
		};
	}

	@Override
	public void sofrerDano(int dano) {
		if (flechaCarregada) {
			log.addLog(getNome() + " foi atingido e perdeu a concentração, desativando Flecha Carregada! Mas não sofreu dano.");
			desativarFlechaCarregada();
		} else {
			this.vida -= dano;
			System.out.println(getNome() + " sofreu " + dano + " de dano!");
		}
	}

	//--------------------- Ações de ataque --------------------

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
		log.addLog(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
	}

	private void ataqueRapido(Monstro monstro) {
		log.addLog(this.getNome() + " desfere ataques rápidos com sua " + armaPrincipal.getNome() + "!");

		int danoBase = this.getAtaque();
		if (armaPrincipal == TipoArma.ADAGA) {
			danoBase -= 5;
			log.addLog("Ataques mais rápidos, mas com menos dano!");
		}

		if (Math.random() < 0.2) {
			log.addLog("Ataque duplo! O Arqueiro desfere um golpe extra!");
			danoBase *= 2;
		}

		int danoFinal = danoBase - monstro.getDefesa();
		if (danoFinal < 0) danoFinal = 0;

		monstro.sofrerDano(danoFinal);
		log.addLog(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
	}

	//--------------------- Ações de defesa --------------------

	public void carregarFlecha() {
		log.addLog(this.getNome() + " prepara uma flecha carregada para o próximo turno!");
		flechaCarregada = true;
	}

	//--------------------- Desativações de escudo --------------------

	public void desativarFlechaCarregada() {
		flechaCarregada = false;
		log.addLog(this.getNome() + " relaxa a tensão do arco e desfaz a Flecha Carregada.");
	}
}
