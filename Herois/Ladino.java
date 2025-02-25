package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static Jogo.Jogo.log;

@Getter
@Setter
public class Ladino extends Heroi {
	private int taxaEsquiva = 4;

	// Construtor principal com todos os atributos
	public Ladino(int vida, int defesa, int destreza, int velocidade) {
		super("Ladino", vida, defesa, destreza, velocidade, TipoHeroi.LADINO);

		List<TipoArma> armasLadino = TipoArma.obterArmasParaLadino();
		this.armaPrincipal = armasLadino.get(RANDOM.nextInt(armasLadino.size()));
		this.ataque = TipoHeroi.LADINO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	// Construtor com valores padrão de um Ladino típico
	public Ladino() {
		super("Ladino", 300, 20, 8, 4, TipoHeroi.LADINO);

		List<TipoArma> armasLadino = TipoArma.obterArmasParaLadino();
		this.armaPrincipal = armasLadino.get(RANDOM.nextInt(armasLadino.size()));
		this.ataque = TipoHeroi.LADINO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	//--------------------- Atributos escudos --------------------

	private boolean ocultoNasSombras = false; // Habilidade passiva que aumenta esquiva

	//--------------------- Factories --------------------

	@Override
	public void realizarAcao(Monstro monstro) throws Exception {
		double chanceDeAcerto = Math.min(0.5 + (this.getDestreza() * 0.05), 1.0); // Base 50% + 5% por ponto de destreza, máx 100%

		if (Math.random() > chanceDeAcerto) {
			log.addLog(this.getNome() + " errou sua ação!");
			return;
		}

		log.addLog(this.getNome() + " atacou " + monstro.getNome() + ".");

		int escolha = RANDOM.nextInt(5);
		switch (escolha) {
			case 0 -> golpePreciso(monstro);
			case 1 -> ataqueRapido(monstro);
			case 2 -> ataqueFurtivo(monstro);
			case 3 -> ataqueBasico(monstro);
			case 4 -> ativarFurtividade();
			default -> throw new Exception();
		};
	}

	@Override
	public void sofrerDano(int dano) {
		if (ocultoNasSombras) {
			log.addLog(this.getNome() + " evitou completamente o ataque ao permanecer nas sombras!");
			desativarFurtividade();
		} else {
			this.vida -= dano;
			log.addLog(this.getNome() + " sofreu " + dano + " de dano!");
		}
	}

	//--------------------- Ações de ataque --------------------

	private void ataqueRapido(Monstro monstro) {
		log.addLog(getNome() + " realiza um ataque rápido com " + armaPrincipal.getNome() + "!");
		int danoFinal = (int) (this.getAtaque() * 1.2) - monstro.getDefesa();
		if (Math.random() < 0.4) { // 40% de chance de acerto crítico
			danoFinal *= 2;
			log.addLog("GOLPE CRÍTICO!");
		}
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	private void golpePreciso(Monstro monstro) {
		log.addLog(getNome() + " desfere um golpe preciso com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() - (monstro.getDefesa() / 2);
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	private void ataqueFurtivo(Monstro monstro) {
		log.addLog(getNome() + " ataca das sombras com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() + 10; // Dano extra quando oculto
		if (ocultoNasSombras) {
			danoFinal += 15;
			log.addLog("Ataque surpresa! Dano extra aplicado.");
		}
		monstro.sofrerDano(Math.max(danoFinal, 0));
		ocultoNasSombras = false; // Revela-se após o ataque
	}

	private void ataqueBasico(Monstro monstro) {
		log.addLog(getNome() + " ataca com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() - monstro.getDefesa();
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	//--------------------- Ações de defesa --------------------

	public void ativarFurtividade() {
		this.ocultoNasSombras = true;
		log.addLog(getNome() + " se escondeu nas sombras!");
	}

	//--------------------- Desativações de escudo --------------------

	public void desativarFurtividade() {
		this.ocultoNasSombras = false;
		log.addLog(getNome() + " foi revelado e saiu das sombras!");
	}
}